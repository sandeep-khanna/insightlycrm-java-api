# insightlycrm-java-api

A Java &amp; Spring Boot based reusable library for integrating Insightly CRM with external systems and applications

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>com.insightly</groupId>
    <artifactId>insightlycrm-java-api</artifactId>
    <version>0.1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "com.insightly:insightlycrm-java-api:0.1.0-SNAPSHOT"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/insightlycrm-java-api-0.1.0-SNAPSHOT.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and review the following Java code:

```java
package com.insightly.etl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.insightly.etl.service.ICustomFieldMetadataService;
import com.insightly.etl.service.ILeadService;
import com.insightly.etl.service.IOrganisationService;
import com.insightly.etl.util.AppConfig;
import com.insightly.etl.util.InsightlyApiException;
import com.insightly.model.Address;
import com.insightly.model.ContactInfo;
import com.insightly.model.CustomField;
import com.insightly.model.CustomFieldMetadata;
import com.insightly.model.Lead;
import com.insightly.model.Organisation;

@Component
public class InsightlyCrmDataEtlImpl {

	@Autowired
	protected ICustomFieldMetadataService customFieldMetadataService;
	@Autowired
	@Qualifier("CustomFieldMetadataServiceDatabaseImpl")
	private ICustomFieldMetadataService customFieldMetadataDatabaseImpl;
	@Autowired
	@Qualifier("CustomFieldMetadataServiceRestImpl")
	private ICustomFieldMetadataService customFieldMetadataRestImpl;
	
	@Autowired
	private ILeadService leadService;
	@Autowired
	@Qualifier("LeadServiceDatabaseImpl")
	private ILeadService leadServiceDatabaseImpl;
	@Autowired
	@Qualifier("LeadServiceRestImpl")
	private ILeadService leadServiceRestImpl;

	@Autowired
	private IOrganisationService organisationService;
	@Autowired
	@Qualifier("OrganisationServiceDatabaseImpl")
	private IOrganisationService organisationServiceDatabaseImpl;
	@Autowired
	@Qualifier("OrganisationServiceRestImpl")
	private IOrganisationService organisationServiceRestImpl;
	
	@Autowired
	@Qualifier("InsightlyCrmEtl")
	private AppConfig appConfig;
	private final Logger logger = LoggerFactory.getLogger(getClass());

	public void addLead() {
		long leadId = 123456789L;
		Lead lead = null;
		
		
		logger.trace("Posting new Insightly {} ...", lead);
		
		try {
			CustomFieldMetadata LEAD_FIELD_1 = customFieldMetadataService.findOptionalByFieldID("LEAD_FIELD_1").orElse(null);
			lead = leadServiceRestImpl.findById(leadId).orElse(null);
			
			if(null != lead) {
				leadService.save(lead);
			} else {
				lead = Lead.builder()
							.id(leadId)
							.firstName("John")
							.lastName("Doe")
							.organizationName("Alphabet Inc.")
							.phone("+1-650-253-0000")
							.email("info@abc.xyz")
							.build();
				lead = leadService.save(lead);
				CustomField customField = CustomField.builder()
														.id(1L)
														.type(LEAD_FIELD_1)
														.value("Lead Custom Field")
														.build();
				leadService.updateCustomField(leadId, customField);
			}			
		} catch(InsightlyApiException ex) {
			logger.error("Error posting new Insightly Lead");
		}
	}
	
	public void addOrganisation() {
		long organisationId = 987654321L;
		Organisation organisation = null;
		
		try {
			CustomFieldMetadata ORGANISATION_FIELD_1 = customFieldMetadataService.findOptionalByFieldID("ORGANISATION_FIELD_1").orElse(null);
			organisation = organisationServiceRestImpl.findById(organisationId).orElse(null);
			
			if(null != organisation) {
				organisationService.save(organisation);
			} else {
				organisation = Organisation.builder()
											.id(organisationId)
											.name("Alphabet Inc.")
											.build();
				organisationService.save(organisation);
					
				// Addresses
				Optional<Address> address = organisation.setShippingAddress("1600 Amphitheatre Pkwy", 
																					"Mountain View", 
																					"CA", 
																					"94043",
																					"United States");
				if(address.isPresent()) {
					Address shippingAddress = address.get();
					shippingAddress.setId(1L);
					organisationService.addAddress(organisationId, shippingAddress);	
				}
				
				// ContactInfos
				Optional<ContactInfo> contactInfo = organisation.setPhone("+1-650-253-0000");
				if(contactInfo.isPresent()) {
					ContactInfo phone = contactInfo.get();
					phone.setId(1L);
					organisationService.addContactInfo(organisationId, phone);	
				}
				
				contactInfo = organisation.setWebsite("http://www.abc.xyz");				
				if(contactInfo.isPresent()) {
					ContactInfo website = contactInfo.get();
					website.setId(2L);
					organisationService.addContactInfo(organisationId, website);	
				}				
				
				contactInfo = organisation.setEmailDomain("abc.xyz");				
				if(contactInfo.isPresent()) {
					ContactInfo emailDomain = contactInfo.get();
					emailDomain.setId(3L);
					organisationService.addContactInfo(organisationId, emailDomain);	
				}				
				
				// CustomFields
				CustomField customField = CustomField.builder()
													.id(2L)
													.type(ORGANISATION_FIELD_1)
													.value("Lead Custom Field")
													.build();
				organisationService.updateCustomField(organisationId, customField);
			}
		} catch(InsightlyApiException ex) {
			logger.error("Error posting new Insightly Organisation");
			ex.printStackTrace();
		}
	}
}
```

## Documentation for API Endpoints

All URIs are relative to *https://api.insight.ly/v2.2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*ActivitySetsApi* | [**getActivitySet**](docs/ActivitySetsApi.md#getActivitySet) | **GET** /ActivitySets/{id} | Gets a single Activity Set
*ActivitySetsApi* | [**getActivitySets**](docs/ActivitySetsApi.md#getActivitySets) | **GET** /ActivitySets | Gets a list of Activity Sets
*CommentsApi* | [**addFileAttachment**](docs/CommentsApi.md#addFileAttachment) | **POST** /Comments/{id}/FileAttachments | Adds a File Attachment to a Comment
*CommentsApi* | [**deleteComment**](docs/CommentsApi.md#deleteComment) | **DELETE** /Comments/{id} | Deletes a Comment
*CommentsApi* | [**getComment**](docs/CommentsApi.md#getComment) | **GET** /Comments/{id} | Gets a Comment
*CommentsApi* | [**getFileAttachments**](docs/CommentsApi.md#getFileAttachments) | **GET** /Comments/{id}/FileAttachments | Gets a Comments&#39;s File Attachments
*CommentsApi* | [**updateComment**](docs/CommentsApi.md#updateComment) | **PUT** /Comments | Updates a Comment
*ContactsApi* | [**addActivitySetAssignment**](docs/ContactsApi.md#addActivitySetAssignment) | **POST** /Contacts/{id}/ActivitySetAssignment | Adds an Activity Set to a Contact
*ContactsApi* | [**addAddress**](docs/ContactsApi.md#addAddress) | **POST** /Contacts/{id}/Addresses | Adds an Address
*ContactsApi* | [**addContact**](docs/ContactsApi.md#addContact) | **POST** /Contacts | Adds a Contact
*ContactsApi* | [**addContactInfo**](docs/ContactsApi.md#addContactInfo) | **POST** /Contacts/{id}/ContactInfos | Adds a Contact Info
*ContactsApi* | [**addContactLink**](docs/ContactsApi.md#addContactLink) | **POST** /Contacts/{id}/ContactLinks | Adds a Contact Link
*ContactsApi* | [**addDate**](docs/ContactsApi.md#addDate) | **POST** /Contacts/{id}/Dates | Adds a Contact Date
*ContactsApi* | [**addFileAttachment**](docs/ContactsApi.md#addFileAttachment) | **POST** /Contacts/{id}/FileAttachments | Adds a File Attachment to a Contact
*ContactsApi* | [**addFollow**](docs/ContactsApi.md#addFollow) | **POST** /Contacts/{id}/Follow | Start following a Contact
*ContactsApi* | [**addLink**](docs/ContactsApi.md#addLink) | **POST** /Contacts/{id}/Links | Adds a Link
*ContactsApi* | [**addNote**](docs/ContactsApi.md#addNote) | **POST** /Contacts/{id}/Notes | Adds a Note to a Contact
*ContactsApi* | [**addTag**](docs/ContactsApi.md#addTag) | **POST** /Contacts/{id}/Tags | Adds a Tag
*ContactsApi* | [**deleteAddress**](docs/ContactsApi.md#deleteAddress) | **DELETE** /Contacts/{id}/Addresses/{addressId} | Deletes an Address
*ContactsApi* | [**deleteContact**](docs/ContactsApi.md#deleteContact) | **DELETE** /Contacts/{id} | Deletes a Contact
*ContactsApi* | [**deleteContactInfo**](docs/ContactsApi.md#deleteContactInfo) | **DELETE** /Contacts/{id}/ContactInfos/{contactInfoId} | Deletes a Contact Info
*ContactsApi* | [**deleteContactLink**](docs/ContactsApi.md#deleteContactLink) | **DELETE** /Contacts/{id}/ContactLinks/{linkId} | Deletes a Contact Link
*ContactsApi* | [**deleteCustomField**](docs/ContactsApi.md#deleteCustomField) | **DELETE** /Contacts/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
*ContactsApi* | [**deleteDate**](docs/ContactsApi.md#deleteDate) | **DELETE** /Contacts/{id}/Dates/{dateId} | Deletes a Contact Date
*ContactsApi* | [**deleteFollow**](docs/ContactsApi.md#deleteFollow) | **DELETE** /Contacts/{id}/Follow | Stop following a Contact
*ContactsApi* | [**deleteImage**](docs/ContactsApi.md#deleteImage) | **DELETE** /Contacts/{id}/Image | Deletes a Contact&#39;s Image
*ContactsApi* | [**deleteLink**](docs/ContactsApi.md#deleteLink) | **DELETE** /Contacts/{id}/Links/{linkId} | Deletes a Link
*ContactsApi* | [**deleteTag**](docs/ContactsApi.md#deleteTag) | **DELETE** /Contacts/{id}/Tags/{tagName} | Deletes a Tag
*ContactsApi* | [**getContact**](docs/ContactsApi.md#getContact) | **GET** /Contacts/{id} | Gets a Contact
*ContactsApi* | [**getContacts**](docs/ContactsApi.md#getContacts) | **GET** /Contacts | Gets a list of Contacts.
*ContactsApi* | [**getContactsBySearch**](docs/ContactsApi.md#getContactsBySearch) | **GET** /Contacts/Search | Gets a filtered list of Contacts.
*ContactsApi* | [**getEmails**](docs/ContactsApi.md#getEmails) | **GET** /Contacts/{id}/Emails | Gets a list of Contact&#39;s Emails
*ContactsApi* | [**getEvents**](docs/ContactsApi.md#getEvents) | **GET** /Contacts/{id}/Events | Gets a Contact&#39;s Events
*ContactsApi* | [**getFileAttachments**](docs/ContactsApi.md#getFileAttachments) | **GET** /Contacts/{id}/FileAttachments | Gets a Contact&#39;s File Attachments
*ContactsApi* | [**getFollow**](docs/ContactsApi.md#getFollow) | **GET** /Contacts/{id}/Follow | Gets a Follow record for the Contact
*ContactsApi* | [**getImage**](docs/ContactsApi.md#getImage) | **GET** /Contacts/{id}/Image | Gets a Contact&#39;s Image
*ContactsApi* | [**getNotes**](docs/ContactsApi.md#getNotes) | **GET** /Contacts/{id}/Notes | Gets a Contact&#39;s Notes
*ContactsApi* | [**getTasks**](docs/ContactsApi.md#getTasks) | **GET** /Contacts/{id}/Tasks | Gets a list of Contact&#39;s Tasks
*ContactsApi* | [**updateAddress**](docs/ContactsApi.md#updateAddress) | **PUT** /Contacts/{id}/Addresses | Updates an Address
*ContactsApi* | [**updateContact**](docs/ContactsApi.md#updateContact) | **PUT** /Contacts | Updates a Contact
*ContactsApi* | [**updateContactInfo**](docs/ContactsApi.md#updateContactInfo) | **PUT** /Contacts/{id}/ContactInfos | Updates a Contact Info
*ContactsApi* | [**updateContactLink**](docs/ContactsApi.md#updateContactLink) | **PUT** /Contacts/{id}/ContactLinks | Updates a Contact Link
*ContactsApi* | [**updateCustomField**](docs/ContactsApi.md#updateCustomField) | **PUT** /Contacts/{id}/CustomFields | Updates a Custom Field
*ContactsApi* | [**updateDate**](docs/ContactsApi.md#updateDate) | **PUT** /Contacts/{id}/Dates | Updates a Contact Date
*ContactsApi* | [**updateImage**](docs/ContactsApi.md#updateImage) | **PUT** /Contacts/{id}/Image/{filename} | Updates a Contact&#39;s Image
*ContactsApi* | [**updateLink**](docs/ContactsApi.md#updateLink) | **PUT** /Contacts/{id}/Links | Updates a Link
*CountriesApi* | [**getCountries**](docs/CountriesApi.md#getCountries) | **GET** /Countries | Gets a list of Countries used by Insightly
*CurrenciesApi* | [**getCurrencies**](docs/CurrenciesApi.md#getCurrencies) | **GET** /Currencies | Gets a list of Currencies used by Insightly
*CustomFieldGroupsApi* | [**getCustomFieldGroups**](docs/CustomFieldGroupsApi.md#getCustomFieldGroups) | **GET** /CustomFieldGroups | Gets a list of Custom Field Groups defined for your instance
*CustomFieldsApi* | [**getCustomFields**](docs/CustomFieldsApi.md#getCustomFields) | **GET** /CustomFields | Gets a list of Custom Fields
*EmailsApi* | [**addComment**](docs/EmailsApi.md#addComment) | **POST** /Emails/{id}/Comments | Adds a Comment to an email.
*EmailsApi* | [**addEmailLink**](docs/EmailsApi.md#addEmailLink) | **POST** /Emails/{id}/EmailLinks | Adds an Email Link
*EmailsApi* | [**addFollow**](docs/EmailsApi.md#addFollow) | **POST** /Emails/{id}/Follow | Start following an Email
*EmailsApi* | [**addTag**](docs/EmailsApi.md#addTag) | **POST** /Emails/{id}/Tags | Adds a Tag for an Email
*EmailsApi* | [**deleteEmailLink**](docs/EmailsApi.md#deleteEmailLink) | **DELETE** /Emails/{id}/EmailLinks/{linkId} | Deletes an Email Link
*EmailsApi* | [**deleteFollow**](docs/EmailsApi.md#deleteFollow) | **DELETE** /Emails/{id}/Follow | Stop following an Email
*EmailsApi* | [**deleteTag**](docs/EmailsApi.md#deleteTag) | **DELETE** /Emails/{id}/Tags/{tagName} | Deletes a Tag from an Email
*EmailsApi* | [**getComments**](docs/EmailsApi.md#getComments) | **GET** /Emails/{id}/Comments | Gets an Email&#39;s Comments
*EmailsApi* | [**getEmail**](docs/EmailsApi.md#getEmail) | **GET** /Emails/{id} | Gets an Email
*EmailsApi* | [**getEmails**](docs/EmailsApi.md#getEmails) | **GET** /Emails | Gets a list of Emails.
*EmailsApi* | [**getEmailsBySearch**](docs/EmailsApi.md#getEmailsBySearch) | **GET** /Emails/Search | Gets a filtered list of Emails.
*EmailsApi* | [**getFileAttachments**](docs/EmailsApi.md#getFileAttachments) | **GET** /Emails/{id}/FileAttachments | Gets an Email&#39;s File Attachments
*EmailsApi* | [**getFollow**](docs/EmailsApi.md#getFollow) | **GET** /Emails/{id}/Follow | Gets a Follow record for the Email
*EventsApi* | [**addEvent**](docs/EventsApi.md#addEvent) | **POST** /Events | Adds a Calendar Event
*EventsApi* | [**addEventLink**](docs/EventsApi.md#addEventLink) | **POST** /Events/{id}/EventLinks | Adds an Event Link
*EventsApi* | [**deleteEvent**](docs/EventsApi.md#deleteEvent) | **DELETE** /Events/{id} | Deletes a Calendar Event
*EventsApi* | [**deleteEventLink**](docs/EventsApi.md#deleteEventLink) | **DELETE** /Events/{id}/EventLinks/{linkId} | Deletes an Event Link
*EventsApi* | [**getEvent**](docs/EventsApi.md#getEvent) | **GET** /Events/{id} | Gets a Calendar Event
*EventsApi* | [**getEvents**](docs/EventsApi.md#getEvents) | **GET** /Events | Gets a list of Calendar Events.
*EventsApi* | [**getEventsBySearch**](docs/EventsApi.md#getEventsBySearch) | **GET** /Events/Search | Gets a filtered list of Calendar Events.
*EventsApi* | [**updateEvent**](docs/EventsApi.md#updateEvent) | **PUT** /Events | Updates a Calendar Event
*FileAttachmentsApi* | [**deleteFileAttachment**](docs/FileAttachmentsApi.md#deleteFileAttachment) | **DELETE** /FileAttachments/{id} | Deletes a File Attachment
*FileAttachmentsApi* | [**getFileAttachment**](docs/FileAttachmentsApi.md#getFileAttachment) | **GET** /FileAttachments/{id} | Gets a File Attachment
*FileCategoriesApi* | [**addFileCategory**](docs/FileCategoriesApi.md#addFileCategory) | **POST** /FileCategories | Adds a File Category
*FileCategoriesApi* | [**deleteFileCategory**](docs/FileCategoriesApi.md#deleteFileCategory) | **DELETE** /FileCategories/{id} | Deactivates a File Category
*FileCategoriesApi* | [**getFileCategories**](docs/FileCategoriesApi.md#getFileCategories) | **GET** /FileCategories | Gets a list of File Categories
*FileCategoriesApi* | [**getFileCategory**](docs/FileCategoriesApi.md#getFileCategory) | **GET** /FileCategories/{id} | Gets a File Category
*FileCategoriesApi* | [**updateFileCategory**](docs/FileCategoriesApi.md#updateFileCategory) | **PUT** /FileCategories | Updates a File Category
*FollowsApi* | [**getFollows**](docs/FollowsApi.md#getFollows) | **GET** /Follows | Gets a list of followed records for the user
*InstanceApi* | [**getInstance**](docs/InstanceApi.md#getInstance) | **GET** /Instance | Gets the Instance
*LeadSourcesApi* | [**addLeadSource**](docs/LeadSourcesApi.md#addLeadSource) | **POST** /LeadSources | Adds a Lead Source
*LeadSourcesApi* | [**deleteLeadSource**](docs/LeadSourcesApi.md#deleteLeadSource) | **DELETE** /LeadSources/{id} | Deletes a Lead Source
*LeadSourcesApi* | [**getLeadSources**](docs/LeadSourcesApi.md#getLeadSources) | **GET** /LeadSources | Gets a list of Lead Sources
*LeadSourcesApi* | [**updateLeadSource**](docs/LeadSourcesApi.md#updateLeadSource) | **PUT** /LeadSources | Updates a Lead Source
*LeadStatusesApi* | [**addLeadStatus**](docs/LeadStatusesApi.md#addLeadStatus) | **POST** /LeadStatuses | Adds a Lead Status
*LeadStatusesApi* | [**deleteLeadStatus**](docs/LeadStatusesApi.md#deleteLeadStatus) | **DELETE** /LeadStatuses/{id} | Deletes a Lead Status
*LeadStatusesApi* | [**getLeadStatuses**](docs/LeadStatusesApi.md#getLeadStatuses) | **GET** /LeadStatuses | Gets a list of Lead Statuses
*LeadStatusesApi* | [**updateLeadStatus**](docs/LeadStatusesApi.md#updateLeadStatus) | **PUT** /LeadStatuses | Updates a Lead Status
*LeadsApi* | [**addActivitySetAssignment**](docs/LeadsApi.md#addActivitySetAssignment) | **POST** /Leads/{id}/ActivitySetAssignment | Adds an Activity Set to a Lead
*LeadsApi* | [**addFileAttachment**](docs/LeadsApi.md#addFileAttachment) | **POST** /Leads/{id}/FileAttachments | Adds a File Attachment to a Lead
*LeadsApi* | [**addFollow**](docs/LeadsApi.md#addFollow) | **POST** /Leads/{id}/Follow | Start following a Lead
*LeadsApi* | [**addLead**](docs/LeadsApi.md#addLead) | **POST** /Leads | Adds a Lead
*LeadsApi* | [**addNote**](docs/LeadsApi.md#addNote) | **POST** /Leads/{id}/Notes | Adds a Note to a Lead.
*LeadsApi* | [**addTag**](docs/LeadsApi.md#addTag) | **POST** /Leads/{id}/Tags | Adds a Tag for a Lead
*LeadsApi* | [**deleteCustomField**](docs/LeadsApi.md#deleteCustomField) | **DELETE** /Leads/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
*LeadsApi* | [**deleteFollow**](docs/LeadsApi.md#deleteFollow) | **DELETE** /Leads/{id}/Follow | Stop following a Lead
*LeadsApi* | [**deleteImage**](docs/LeadsApi.md#deleteImage) | **DELETE** /Leads/{id}/Image | Deletes a Lead&#39;s Image
*LeadsApi* | [**deleteLead**](docs/LeadsApi.md#deleteLead) | **DELETE** /Leads/{id} | Deletes a Lead
*LeadsApi* | [**deleteTag**](docs/LeadsApi.md#deleteTag) | **DELETE** /Leads/{id}/Tags/{tagName} | Deletes a Tag from a Lead
*LeadsApi* | [**getEmails**](docs/LeadsApi.md#getEmails) | **GET** /Leads/{id}/Emails | Gets a list of Lead&#39;s Emails
*LeadsApi* | [**getEvents**](docs/LeadsApi.md#getEvents) | **GET** /Leads/{id}/Events | Gets a Lead&#39;s Events
*LeadsApi* | [**getFileAttachments**](docs/LeadsApi.md#getFileAttachments) | **GET** /Leads/{id}/FileAttachments | Gets a Lead&#39;s File Attachments
*LeadsApi* | [**getFollow**](docs/LeadsApi.md#getFollow) | **GET** /Leads/{id}/Follow | Gets a Follow record for the Lead
*LeadsApi* | [**getImage**](docs/LeadsApi.md#getImage) | **GET** /Leads/{id}/Image | Gets a Lead&#39;s Image
*LeadsApi* | [**getLead**](docs/LeadsApi.md#getLead) | **GET** /Leads/{id} | Gets a Lead
*LeadsApi* | [**getLeads**](docs/LeadsApi.md#getLeads) | **GET** /Leads | Gets a list of Leads.
*LeadsApi* | [**getLeadsBySearch**](docs/LeadsApi.md#getLeadsBySearch) | **GET** /Leads/Search | Gets a filtered list of Leads.
*LeadsApi* | [**getLinkEmailAddress**](docs/LeadsApi.md#getLinkEmailAddress) | **GET** /Leads/{id}/LinkEmailAddress | Gets the email address to use for linking with the Lead
*LeadsApi* | [**getNotes**](docs/LeadsApi.md#getNotes) | **GET** /Leads/{id}/Notes | Gets a Lead&#39;s Notes
*LeadsApi* | [**getTasks**](docs/LeadsApi.md#getTasks) | **GET** /Leads/{id}/Tasks | Gets a list of Lead&#39;s Tasks
*LeadsApi* | [**updateCustomField**](docs/LeadsApi.md#updateCustomField) | **PUT** /Leads/{id}/CustomFields | Updates a Custom Field
*LeadsApi* | [**updateImage**](docs/LeadsApi.md#updateImage) | **PUT** /Leads/{id}/Image/{filename} | Updates a Lead&#39;s Image
*LeadsApi* | [**updateLead**](docs/LeadsApi.md#updateLead) | **PUT** /Leads | Updates a Lead
*MilestonesApi* | [**getMilestones**](docs/MilestonesApi.md#getMilestones) | **GET** /Milestones | Gets a list of Milestones.
*MilestonesApi* | [**getMilestonesBySearch**](docs/MilestonesApi.md#getMilestonesBySearch) | **GET** /Milestones/Search | Gets a filtered list of Milestones.
*NotesApi* | [**addComment**](docs/NotesApi.md#addComment) | **POST** /Notes/{id}/Comments | Adds a Comment to a Note
*NotesApi* | [**addFileAttachment**](docs/NotesApi.md#addFileAttachment) | **POST** /Notes/{id}/FileAttachments | Adds a File Attachment to a Note
*NotesApi* | [**addFollow**](docs/NotesApi.md#addFollow) | **POST** /Notes/{id}/Follow | Start following a Note
*NotesApi* | [**addNoteLink**](docs/NotesApi.md#addNoteLink) | **POST** /Notes/{id}/NoteLinks | Adds a Note Link
*NotesApi* | [**deleteFollow**](docs/NotesApi.md#deleteFollow) | **DELETE** /Notes/{id}/Follow | Stop following a Note
*NotesApi* | [**deleteNote**](docs/NotesApi.md#deleteNote) | **DELETE** /Notes/{id} | Deletes a Note
*NotesApi* | [**deleteNoteLink**](docs/NotesApi.md#deleteNoteLink) | **DELETE** /Notes/{id}/NoteLinks/{linkId} | Deletes a Note Link
*NotesApi* | [**getComments**](docs/NotesApi.md#getComments) | **GET** /Notes/{id}/Comments | Gets a Note&#39;s Comments
*NotesApi* | [**getFileAttachments**](docs/NotesApi.md#getFileAttachments) | **GET** /Notes/{id}/FileAttachments | Gets a Note&#39;s File Attachments
*NotesApi* | [**getFollow**](docs/NotesApi.md#getFollow) | **GET** /Notes/{id}/Follow | Gets a Follow record for the Note
*NotesApi* | [**getNote**](docs/NotesApi.md#getNote) | **GET** /Notes/{id} | Gets a Note
*NotesApi* | [**getNotes**](docs/NotesApi.md#getNotes) | **GET** /Notes | Gets a list of Notes.
*NotesApi* | [**getNotesBySearch**](docs/NotesApi.md#getNotesBySearch) | **GET** /Notes/Search | Gets a filtered list of Notes.
*NotesApi* | [**updateNote**](docs/NotesApi.md#updateNote) | **PUT** /Notes | Updates a Note
*OpportunitiesApi* | [**addActivitySetAssignment**](docs/OpportunitiesApi.md#addActivitySetAssignment) | **POST** /Opportunities/{id}/ActivitySetAssignment | Adds an Activity Set to an Opportunity
*OpportunitiesApi* | [**addFileAttachment**](docs/OpportunitiesApi.md#addFileAttachment) | **POST** /Opportunities/{id}/FileAttachments | Adds a File Attachment to an Opportunity
*OpportunitiesApi* | [**addFollow**](docs/OpportunitiesApi.md#addFollow) | **POST** /Opportunities/{id}/Follow | Start following an Opportunity
*OpportunitiesApi* | [**addLink**](docs/OpportunitiesApi.md#addLink) | **POST** /Opportunities/{id}/Links | Adds a Link
*OpportunitiesApi* | [**addNote**](docs/OpportunitiesApi.md#addNote) | **POST** /Opportunities/{id}/Notes | Adds a Note to an Opportunity.
*OpportunitiesApi* | [**addOpportunity**](docs/OpportunitiesApi.md#addOpportunity) | **POST** /Opportunities | Adds an Opportunity
*OpportunitiesApi* | [**addTag**](docs/OpportunitiesApi.md#addTag) | **POST** /Opportunities/{id}/Tags | Adds a Tag for an Opportunity
*OpportunitiesApi* | [**deleteCustomField**](docs/OpportunitiesApi.md#deleteCustomField) | **DELETE** /Opportunities/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
*OpportunitiesApi* | [**deleteFollow**](docs/OpportunitiesApi.md#deleteFollow) | **DELETE** /Opportunities/{id}/Follow | Stop following an Opportunity
*OpportunitiesApi* | [**deleteImage**](docs/OpportunitiesApi.md#deleteImage) | **DELETE** /Opportunities/{id}/Image | Deletes an Opportunity&#39;s Image
*OpportunitiesApi* | [**deleteLink**](docs/OpportunitiesApi.md#deleteLink) | **DELETE** /Opportunities/{id}/Links/{linkId} | Deletes a Link
*OpportunitiesApi* | [**deleteOpportunity**](docs/OpportunitiesApi.md#deleteOpportunity) | **DELETE** /Opportunities/{id} | Deletes an Opportunity
*OpportunitiesApi* | [**deletePipeline**](docs/OpportunitiesApi.md#deletePipeline) | **DELETE** /Opportunities/{id}/Pipeline | Clears pipeline for the opportunity.
*OpportunitiesApi* | [**deleteTag**](docs/OpportunitiesApi.md#deleteTag) | **DELETE** /Opportunities/{id}/Tags/{tagName} | Deletes a Tag from an Opportunity
*OpportunitiesApi* | [**getEmails**](docs/OpportunitiesApi.md#getEmails) | **GET** /Opportunities/{id}/Emails | Gets a list of Opportunity&#39;s Emails
*OpportunitiesApi* | [**getEvents**](docs/OpportunitiesApi.md#getEvents) | **GET** /Opportunities/{id}/Events | Gets an Opportunity&#39;s Events
*OpportunitiesApi* | [**getFileAttachments**](docs/OpportunitiesApi.md#getFileAttachments) | **GET** /Opportunities/{id}/FileAttachments | Gets an Opportunity&#39;s File Attachments
*OpportunitiesApi* | [**getFollow**](docs/OpportunitiesApi.md#getFollow) | **GET** /Opportunities/{id}/Follow | Gets a Follow record for the Opportunity
*OpportunitiesApi* | [**getImage**](docs/OpportunitiesApi.md#getImage) | **GET** /Opportunities/{id}/Image | Gets an Opportunity&#39;s Image
*OpportunitiesApi* | [**getLinkEmailAddress**](docs/OpportunitiesApi.md#getLinkEmailAddress) | **GET** /Opportunities/{id}/LinkEmailAddress | Gets the email address to use for linking with the opportunity
*OpportunitiesApi* | [**getNotes**](docs/OpportunitiesApi.md#getNotes) | **GET** /Opportunities/{id}/Notes | Gets an Opportunity&#39;s Notes
*OpportunitiesApi* | [**getOpportunities**](docs/OpportunitiesApi.md#getOpportunities) | **GET** /Opportunities | Gets a list of Opportunities.
*OpportunitiesApi* | [**getOpportunitiesBySearch**](docs/OpportunitiesApi.md#getOpportunitiesBySearch) | **GET** /Opportunities/Search | Gets a filtered list of Opportunities.
*OpportunitiesApi* | [**getOpportunity**](docs/OpportunitiesApi.md#getOpportunity) | **GET** /Opportunities/{id} | Gets an Opportunity
*OpportunitiesApi* | [**getStateHistory**](docs/OpportunitiesApi.md#getStateHistory) | **GET** /Opportunities/{id}/StateHistory | Gets the history of States and Reasons for an Opportunity.
*OpportunitiesApi* | [**getTasks**](docs/OpportunitiesApi.md#getTasks) | **GET** /Opportunities/{id}/Tasks | Gets a list of Opportunity&#39;s Tasks
*OpportunitiesApi* | [**updateCustomField**](docs/OpportunitiesApi.md#updateCustomField) | **PUT** /Opportunities/{id}/CustomFields | Updates a Custom Field
*OpportunitiesApi* | [**updateImage**](docs/OpportunitiesApi.md#updateImage) | **PUT** /Opportunities/{id}/Image/{filename} | Updates an Opportunity&#39;s Image
*OpportunitiesApi* | [**updateLink**](docs/OpportunitiesApi.md#updateLink) | **PUT** /Opportunities/{id}/Links | Updates a Link
*OpportunitiesApi* | [**updateOpportunity**](docs/OpportunitiesApi.md#updateOpportunity) | **PUT** /Opportunities | Updates an Opportunity
*OpportunitiesApi* | [**updatePipeline**](docs/OpportunitiesApi.md#updatePipeline) | **PUT** /Opportunities/{id}/Pipeline | Changes current pipeline for the opportunity.
*OpportunitiesApi* | [**updatePipelineStage**](docs/OpportunitiesApi.md#updatePipelineStage) | **PUT** /Opportunities/{id}/PipelineStage | Changes current pipeline stage for the opportunity.
*OpportunityCategoriesApi* | [**addOpportunityCategory**](docs/OpportunityCategoriesApi.md#addOpportunityCategory) | **POST** /OpportunityCategories | Adds an Opportunity Category
*OpportunityCategoriesApi* | [**deleteOpportunityCategory**](docs/OpportunityCategoriesApi.md#deleteOpportunityCategory) | **DELETE** /OpportunityCategories/{id} | Deactivates an Opportunity Category
*OpportunityCategoriesApi* | [**getOpportunityCategories**](docs/OpportunityCategoriesApi.md#getOpportunityCategories) | **GET** /OpportunityCategories | Gets a list of Opportunity Categories
*OpportunityCategoriesApi* | [**getOpportunityCategory**](docs/OpportunityCategoriesApi.md#getOpportunityCategory) | **GET** /OpportunityCategories/{id} | Gets an Opportunity Category
*OpportunityCategoriesApi* | [**updateOpportunityCategory**](docs/OpportunityCategoriesApi.md#updateOpportunityCategory) | **PUT** /OpportunityCategories | Updates an Opportunity Category
*OpportunityStateReasonsApi* | [**getOpportunityStateReasons**](docs/OpportunityStateReasonsApi.md#getOpportunityStateReasons) | **GET** /OpportunityStateReasons | Gets a list of Opportunity State Reasons
*OrganisationsApi* | [**addActivitySetAssignment**](docs/OrganisationsApi.md#addActivitySetAssignment) | **POST** /Organisations/{id}/ActivitySetAssignment | Adds an Activity Set to an Organisation
*OrganisationsApi* | [**addAddress**](docs/OrganisationsApi.md#addAddress) | **POST** /Organisations/{id}/Addresses | Adds an Address
*OrganisationsApi* | [**addContactInfo**](docs/OrganisationsApi.md#addContactInfo) | **POST** /Organisations/{id}/ContactInfos | Adds a Contact Info
*OrganisationsApi* | [**addDate**](docs/OrganisationsApi.md#addDate) | **POST** /Organisations/{id}/Dates | Adds an Organisation Date
*OrganisationsApi* | [**addFileAttachment**](docs/OrganisationsApi.md#addFileAttachment) | **POST** /Organisations/{id}/FileAttachments | Adds a File Attachment to an Organisation
*OrganisationsApi* | [**addFollow**](docs/OrganisationsApi.md#addFollow) | **POST** /Organisations/{id}/Follow | Start following an Organisation
*OrganisationsApi* | [**addLink**](docs/OrganisationsApi.md#addLink) | **POST** /Organisations/{id}/Links | Adds a Link
*OrganisationsApi* | [**addNote**](docs/OrganisationsApi.md#addNote) | **POST** /Organisations/{id}/Notes | Adds a Note to an Organisation
*OrganisationsApi* | [**addOrganisation**](docs/OrganisationsApi.md#addOrganisation) | **POST** /Organisations | Adds an Organisation
*OrganisationsApi* | [**addOrganisationLink**](docs/OrganisationsApi.md#addOrganisationLink) | **POST** /Organisations/{id}/OrganisationLinks | Adds an Organisation Link
*OrganisationsApi* | [**addTag**](docs/OrganisationsApi.md#addTag) | **POST** /Organisations/{id}/Tags | Adds a Tag
*OrganisationsApi* | [**deleteAddress**](docs/OrganisationsApi.md#deleteAddress) | **DELETE** /Organisations/{id}/Addresses/{addressId} | Deletes an Address
*OrganisationsApi* | [**deleteContactInfo**](docs/OrganisationsApi.md#deleteContactInfo) | **DELETE** /Organisations/{id}/ContactInfos/{contactInfoId} | Deletes a Contact Info
*OrganisationsApi* | [**deleteCustomField**](docs/OrganisationsApi.md#deleteCustomField) | **DELETE** /Organisations/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
*OrganisationsApi* | [**deleteDate**](docs/OrganisationsApi.md#deleteDate) | **DELETE** /Organisations/{id}/Dates/{dateId} | Deletes an Organisation Date
*OrganisationsApi* | [**deleteFollow**](docs/OrganisationsApi.md#deleteFollow) | **DELETE** /Organisations/{id}/Follow | Stop following an Organisation
*OrganisationsApi* | [**deleteImage**](docs/OrganisationsApi.md#deleteImage) | **DELETE** /Organisations/{id}/Image | Deletes an Organisation&#39;s Image
*OrganisationsApi* | [**deleteLink**](docs/OrganisationsApi.md#deleteLink) | **DELETE** /Organisations/{id}/Links/{linkId} | Deletes a Link
*OrganisationsApi* | [**deleteOrganisation**](docs/OrganisationsApi.md#deleteOrganisation) | **DELETE** /Organisations/{id} | Deletes an Organisation
*OrganisationsApi* | [**deleteOrganisationLink**](docs/OrganisationsApi.md#deleteOrganisationLink) | **DELETE** /Organisations/{id}/OrganisationLinks/{linkId} | Deletes an Organisation Link
*OrganisationsApi* | [**deleteTag**](docs/OrganisationsApi.md#deleteTag) | **DELETE** /Organisations/{id}/Tags/{tagName} | Deletes a Tag
*OrganisationsApi* | [**getEmails**](docs/OrganisationsApi.md#getEmails) | **GET** /Organisations/{id}/Emails | Gets a list of Organisation&#39;s Emails
*OrganisationsApi* | [**getEvents**](docs/OrganisationsApi.md#getEvents) | **GET** /Organisations/{id}/Events | Gets an Organisation&#39;s Events
*OrganisationsApi* | [**getFileAttachments**](docs/OrganisationsApi.md#getFileAttachments) | **GET** /Organisations/{id}/FileAttachments | Gets an Organisation&#39;s File Attachments
*OrganisationsApi* | [**getFollow**](docs/OrganisationsApi.md#getFollow) | **GET** /Organisations/{id}/Follow | Gets a Follow record for the Organisation
*OrganisationsApi* | [**getImage**](docs/OrganisationsApi.md#getImage) | **GET** /Organisations/{id}/Image | Gets an Organisations&#39;s Image
*OrganisationsApi* | [**getNotes**](docs/OrganisationsApi.md#getNotes) | **GET** /Organisations/{id}/Notes | Gets an Organisation&#39;s Notes
*OrganisationsApi* | [**getOrganisation**](docs/OrganisationsApi.md#getOrganisation) | **GET** /Organisations/{id} | Gets an Organisation
*OrganisationsApi* | [**getOrganisations**](docs/OrganisationsApi.md#getOrganisations) | **GET** /Organisations | Gets a list of Organisations.
*OrganisationsApi* | [**getOrganisationsBySearch**](docs/OrganisationsApi.md#getOrganisationsBySearch) | **GET** /Organisations/Search | Gets a filtered list of Organisations.
*OrganisationsApi* | [**getTasks**](docs/OrganisationsApi.md#getTasks) | **GET** /Organisations/{id}/Tasks | Gets a list of Organisation&#39;s Tasks
*OrganisationsApi* | [**updateAddress**](docs/OrganisationsApi.md#updateAddress) | **PUT** /Organisations/{id}/Addresses | Updates an Address
*OrganisationsApi* | [**updateContactInfo**](docs/OrganisationsApi.md#updateContactInfo) | **PUT** /Organisations/{id}/ContactInfos | Updates a Contact Info
*OrganisationsApi* | [**updateCustomField**](docs/OrganisationsApi.md#updateCustomField) | **PUT** /Organisations/{id}/CustomFields | Updates a Custom Field
*OrganisationsApi* | [**updateDate**](docs/OrganisationsApi.md#updateDate) | **PUT** /Organisations/{id}/Dates | Updates an Organisation Date
*OrganisationsApi* | [**updateImage**](docs/OrganisationsApi.md#updateImage) | **PUT** /Organisations/{id}/Image/{filename} | Updates an Organisation&#39;s Image
*OrganisationsApi* | [**updateLink**](docs/OrganisationsApi.md#updateLink) | **PUT** /Organisations/{id}/Links | Updates a Link
*OrganisationsApi* | [**updateOrganisation**](docs/OrganisationsApi.md#updateOrganisation) | **PUT** /Organisations | Updates an Organisation
*OrganisationsApi* | [**updateOrganisationLink**](docs/OrganisationsApi.md#updateOrganisationLink) | **PUT** /Organisations/{id}/OrganisationLinks | Updates an Organisation Link
*PermissionsApi* | [**getPermissions**](docs/PermissionsApi.md#getPermissions) | **GET** /Permissions | Gets the Permissions for a User
*PipelineStagesApi* | [**getPipelineStage**](docs/PipelineStagesApi.md#getPipelineStage) | **GET** /PipelineStages/{id} | Gets a Pipeline Stage
*PipelineStagesApi* | [**getPipelineStages**](docs/PipelineStagesApi.md#getPipelineStages) | **GET** /PipelineStages | Gets a list of Pipeline Stages
*PipelinesApi* | [**getPipeline**](docs/PipelinesApi.md#getPipeline) | **GET** /Pipelines/{id} | Gets a Pipeline
*PipelinesApi* | [**getPipelines**](docs/PipelinesApi.md#getPipelines) | **GET** /Pipelines | Gets a list of Pipelines
*ProjectCategoriesApi* | [**addProjectCategory**](docs/ProjectCategoriesApi.md#addProjectCategory) | **POST** /ProjectCategories | Adds a Project Category
*ProjectCategoriesApi* | [**deleteProjectCategory**](docs/ProjectCategoriesApi.md#deleteProjectCategory) | **DELETE** /ProjectCategories/{id} | Deactivates a Project Category
*ProjectCategoriesApi* | [**getProjectCategories**](docs/ProjectCategoriesApi.md#getProjectCategories) | **GET** /ProjectCategories | Gets a list of Project Categories
*ProjectCategoriesApi* | [**getProjectCategory**](docs/ProjectCategoriesApi.md#getProjectCategory) | **GET** /ProjectCategories/{id} | Gets a Project Category
*ProjectCategoriesApi* | [**updateProjectCategory**](docs/ProjectCategoriesApi.md#updateProjectCategory) | **PUT** /ProjectCategories | Updates a Project Category
*ProjectsApi* | [**addActivitySetAssignment**](docs/ProjectsApi.md#addActivitySetAssignment) | **POST** /Projects/{id}/ActivitySetAssignment | Adds an Activity Set to a Project
*ProjectsApi* | [**addFileAttachment**](docs/ProjectsApi.md#addFileAttachment) | **POST** /Projects/{id}/FileAttachments | Adds a File Attachment to a Project
*ProjectsApi* | [**addFollow**](docs/ProjectsApi.md#addFollow) | **POST** /Projects/{id}/Follow | Start following a Project
*ProjectsApi* | [**addLink**](docs/ProjectsApi.md#addLink) | **POST** /Projects/{id}/Links | Adds a Link to a project
*ProjectsApi* | [**addMilestone**](docs/ProjectsApi.md#addMilestone) | **POST** /Projects/{id}/Milestones | Adds a Milestone to a Project
*ProjectsApi* | [**addNote**](docs/ProjectsApi.md#addNote) | **POST** /Projects/{id}/Notes | Adds a Note to a Project.
*ProjectsApi* | [**addProject**](docs/ProjectsApi.md#addProject) | **POST** /Projects | Adds a Project
*ProjectsApi* | [**addTag**](docs/ProjectsApi.md#addTag) | **POST** /Projects/{id}/Tags | Adds a Tag for a Project
*ProjectsApi* | [**deleteCustomField**](docs/ProjectsApi.md#deleteCustomField) | **DELETE** /Projects/{id}/CustomFields/{customFieldId} | Deletes a Custom Field
*ProjectsApi* | [**deleteFollow**](docs/ProjectsApi.md#deleteFollow) | **DELETE** /Projects/{id}/Follow | Stop following a Project
*ProjectsApi* | [**deleteImage**](docs/ProjectsApi.md#deleteImage) | **DELETE** /Projects/{id}/Image | Deletes a Project&#39;s Image
*ProjectsApi* | [**deleteLink**](docs/ProjectsApi.md#deleteLink) | **DELETE** /Projects/{id}/Links/{linkId} | Deletes a Link from a project
*ProjectsApi* | [**deleteMilestone**](docs/ProjectsApi.md#deleteMilestone) | **DELETE** /Projects/{id}/Milestones/{milestoneId} | Deletes a Milestone from a Project
*ProjectsApi* | [**deletePipeline**](docs/ProjectsApi.md#deletePipeline) | **DELETE** /Projects/{id}/Pipeline | Clears pipeline for the Project.
*ProjectsApi* | [**deleteProject**](docs/ProjectsApi.md#deleteProject) | **DELETE** /Projects/{id} | Deletes a Project
*ProjectsApi* | [**deleteTag**](docs/ProjectsApi.md#deleteTag) | **DELETE** /Projects/{id}/Tags/{tagName} | Deletes a Tag from a Project
*ProjectsApi* | [**getEmails**](docs/ProjectsApi.md#getEmails) | **GET** /Projects/{id}/Emails | Gets a list of Project&#39;s Emails
*ProjectsApi* | [**getEvents**](docs/ProjectsApi.md#getEvents) | **GET** /Projects/{id}/Events | Gets a Project&#39;s Events
*ProjectsApi* | [**getFileAttachments**](docs/ProjectsApi.md#getFileAttachments) | **GET** /Projects/{id}/FileAttachments | Gets a Project&#39;s File Attachments
*ProjectsApi* | [**getFollow**](docs/ProjectsApi.md#getFollow) | **GET** /Projects/{id}/Follow | Gets a Follow record for the Project
*ProjectsApi* | [**getImage**](docs/ProjectsApi.md#getImage) | **GET** /Projects/{id}/Image | Gets a Project&#39;s Image
*ProjectsApi* | [**getLinkEmailAddress**](docs/ProjectsApi.md#getLinkEmailAddress) | **GET** /Projects/{id}/LinkEmailAddress | Gets the email address to use for linking with the Project
*ProjectsApi* | [**getMilestones**](docs/ProjectsApi.md#getMilestones) | **GET** /Projects/{id}/Milestones | Gets a list of Milestones for a Project
*ProjectsApi* | [**getNotes**](docs/ProjectsApi.md#getNotes) | **GET** /Projects/{id}/Notes | Gets a Project&#39;s Notes
*ProjectsApi* | [**getProject**](docs/ProjectsApi.md#getProject) | **GET** /Projects/{id} | Gets a Project
*ProjectsApi* | [**getProjects**](docs/ProjectsApi.md#getProjects) | **GET** /Projects | Gets a list of Projects.
*ProjectsApi* | [**getProjectsBySearch**](docs/ProjectsApi.md#getProjectsBySearch) | **GET** /Projects/Search | Gets a filtered list of Projects.
*ProjectsApi* | [**getTasks**](docs/ProjectsApi.md#getTasks) | **GET** /Projects/{id}/Tasks | Gets a list of Project&#39;s Tasks
*ProjectsApi* | [**updateCustomField**](docs/ProjectsApi.md#updateCustomField) | **PUT** /Projects/{id}/CustomFields | Updates a Custom Field
*ProjectsApi* | [**updateImage**](docs/ProjectsApi.md#updateImage) | **PUT** /Projects/{id}/Image/{filename} | Updates a Project&#39;s Image
*ProjectsApi* | [**updateLink**](docs/ProjectsApi.md#updateLink) | **PUT** /Projects/{id}/Links | Updates a Link for a project
*ProjectsApi* | [**updateMilestone**](docs/ProjectsApi.md#updateMilestone) | **PUT** /Projects/{id}/Milestones | Updates a Milestone for a Project
*ProjectsApi* | [**updatePipeline**](docs/ProjectsApi.md#updatePipeline) | **PUT** /Projects/{id}/Pipeline | Changes current pipeline for the project.
*ProjectsApi* | [**updatePipelineStage**](docs/ProjectsApi.md#updatePipelineStage) | **PUT** /Projects/{id}/PipelineStage | Changes current pipeline stage for the project.
*ProjectsApi* | [**updateProject**](docs/ProjectsApi.md#updateProject) | **PUT** /Projects | Updates a Project
*RelationshipsApi* | [**getRelationships**](docs/RelationshipsApi.md#getRelationships) | **GET** /Relationships | Gets a list of Relationships
*TagsApi* | [**getTags**](docs/TagsApi.md#getTags) | **GET** /Tags | Gets a list of Tags used for a record type
*TaskCategoriesApi* | [**addTaskCategory**](docs/TaskCategoriesApi.md#addTaskCategory) | **POST** /TaskCategories | Adds a Task Category
*TaskCategoriesApi* | [**deleteTaskCategory**](docs/TaskCategoriesApi.md#deleteTaskCategory) | **DELETE** /TaskCategories/{id} | Deactivates a Task Category
*TaskCategoriesApi* | [**getTaskCategories**](docs/TaskCategoriesApi.md#getTaskCategories) | **GET** /TaskCategories | Gets a list of Task Categories
*TaskCategoriesApi* | [**getTaskCategory**](docs/TaskCategoriesApi.md#getTaskCategory) | **GET** /TaskCategories/{id} | Gets a Task Category
*TaskCategoriesApi* | [**updateTaskCategory**](docs/TaskCategoriesApi.md#updateTaskCategory) | **PUT** /TaskCategories | Updates a Task Category
*TasksApi* | [**addComment**](docs/TasksApi.md#addComment) | **POST** /Tasks/{id}/Comments | Adds a Comment to a task.
*TasksApi* | [**addFollow**](docs/TasksApi.md#addFollow) | **POST** /Tasks/{id}/Follow | Start following a Task
*TasksApi* | [**addTask**](docs/TasksApi.md#addTask) | **POST** /Tasks | Adds a Task
*TasksApi* | [**addTaskLink**](docs/TasksApi.md#addTaskLink) | **POST** /Tasks/{id}/TaskLinks | Adds a Task Link
*TasksApi* | [**deleteFollow**](docs/TasksApi.md#deleteFollow) | **DELETE** /Tasks/{id}/Follow | Stop following a Task
*TasksApi* | [**deleteTask**](docs/TasksApi.md#deleteTask) | **DELETE** /Tasks/{id} | Deletes a Task
*TasksApi* | [**deleteTaskLink**](docs/TasksApi.md#deleteTaskLink) | **DELETE** /Tasks/{id}/TaskLinks/{linkId} | Deletes a Task Link
*TasksApi* | [**getComments**](docs/TasksApi.md#getComments) | **GET** /Tasks/{id}/Comments | Gets a Task&#39;s Comments
*TasksApi* | [**getFollow**](docs/TasksApi.md#getFollow) | **GET** /Tasks/{id}/Follow | Gets a Follow record for the Task
*TasksApi* | [**getTask**](docs/TasksApi.md#getTask) | **GET** /Tasks/{id} | Gets a Task
*TasksApi* | [**getTasks**](docs/TasksApi.md#getTasks) | **GET** /Tasks | Gets a list of Tasks.
*TasksApi* | [**getTasksBySearch**](docs/TasksApi.md#getTasksBySearch) | **GET** /Tasks/Search | Gets a filtered list of Tasks.
*TasksApi* | [**updateTask**](docs/TasksApi.md#updateTask) | **PUT** /Tasks | Updates a Task
*TeamMembersApi* | [**addTeamMember**](docs/TeamMembersApi.md#addTeamMember) | **POST** /TeamMembers | Adds a new Team Member
*TeamMembersApi* | [**deleteTeamMember**](docs/TeamMembersApi.md#deleteTeamMember) | **DELETE** /TeamMembers/{id} | Deletes a Team Member
*TeamMembersApi* | [**getTeamMember**](docs/TeamMembersApi.md#getTeamMember) | **GET** /TeamMembers/{id} | Gets a Team Member
*TeamMembersApi* | [**getTeamMembers**](docs/TeamMembersApi.md#getTeamMembers) | **GET** /TeamMembers | Gets a list of Team Members
*TeamsApi* | [**addTeam**](docs/TeamsApi.md#addTeam) | **POST** /Teams | Adds a Team
*TeamsApi* | [**addTeamMember**](docs/TeamsApi.md#addTeamMember) | **POST** /Teams/{id}/TeamMembers | Adds a Team Member
*TeamsApi* | [**deleteTeam**](docs/TeamsApi.md#deleteTeam) | **DELETE** /Teams/{id} | Deletes a Team
*TeamsApi* | [**deleteTeamMember**](docs/TeamsApi.md#deleteTeamMember) | **DELETE** /Teams/{id}/TeamMembers/{permissionId} | Deletes a Team Member
*TeamsApi* | [**getTeam**](docs/TeamsApi.md#getTeam) | **GET** /Teams/{id} | Gets a Team
*TeamsApi* | [**getTeams**](docs/TeamsApi.md#getTeams) | **GET** /Teams | Gets a list of Teams.
*TeamsApi* | [**getTeamsBySearch**](docs/TeamsApi.md#getTeamsBySearch) | **GET** /Teams/Search | Gets a filtered list of Teams.
*TeamsApi* | [**updateTeam**](docs/TeamsApi.md#updateTeam) | **PUT** /Teams | Updates a Team
*UsersApi* | [**getUser**](docs/UsersApi.md#getUser) | **GET** /Users/{id} | Gets a User
*UsersApi* | [**getUserMe**](docs/UsersApi.md#getUserMe) | **GET** /Users/Me | Gets the User object for the calling user.
*UsersApi* | [**getUsers**](docs/UsersApi.md#getUsers) | **GET** /Users | Gets a list of Users
*UsersApi* | [**getUsersBySearch**](docs/UsersApi.md#getUsersBySearch) | **GET** /Users/Search | Gets a filtered list of Users


## Documentation for Models

 - [Activity](docs/Activity.md)
 - [ActivityAssignment](docs/ActivityAssignment.md)
 - [ActivitySet](docs/ActivitySet.md)
 - [ActivitySetAssignment](docs/ActivitySetAssignment.md)
 - [Address](docs/Address.md)
 - [CalendarEvent](docs/CalendarEvent.md)
 - [Category](docs/Category.md)
 - [Comment](docs/Comment.md)
 - [Contact](docs/Contact.md)
 - [ContactDate](docs/ContactDate.md)
 - [ContactInfo](docs/ContactInfo.md)
 - [ContactLink](docs/ContactLink.md)
 - [Country](docs/Country.md)
 - [Currency](docs/Currency.md)
 - [CustomField](docs/CustomField.md)
 - [CustomFieldGroup](docs/CustomFieldGroup.md)
 - [CustomFieldMetadata](docs/CustomFieldMetadata.md)
 - [CustomFieldOption](docs/CustomFieldOption.md)
 - [Email](docs/Email.md)
 - [EmailLink](docs/EmailLink.md)
 - [EventLink](docs/EventLink.md)
 - [File](docs/File.md)
 - [FileAttachment](docs/FileAttachment.md)
 - [Follow](docs/Follow.md)
 - [Instance](docs/Instance.md)
 - [Lead](docs/Lead.md)
 - [LeadSource](docs/LeadSource.md)
 - [LeadStatus](docs/LeadStatus.md)
 - [Link](docs/Link.md)
 - [LinkEmailAddress](docs/LinkEmailAddress.md)
 - [Milestone](docs/Milestone.md)
 - [Note](docs/Note.md)
 - [NoteLink](docs/NoteLink.md)
 - [ObjectPermissions](docs/ObjectPermissions.md)
 - [Opportunity](docs/Opportunity.md)
 - [OpportunityState](docs/OpportunityState.md)
 - [OpportunityStateReason](docs/OpportunityStateReason.md)
 - [Organisation](docs/Organisation.md)
 - [OrganisationDate](docs/OrganisationDate.md)
 - [OrganisationLink](docs/OrganisationLink.md)
 - [Permissions](docs/Permissions.md)
 - [Pipeline](docs/Pipeline.md)
 - [PipelineChange](docs/PipelineChange.md)
 - [PipelineStage](docs/PipelineStage.md)
 - [PipelineStageChange](docs/PipelineStageChange.md)
 - [Project](docs/Project.md)
 - [Relationship](docs/Relationship.md)
 - [Tag](docs/Tag.md)
 - [Task](docs/Task.md)
 - [TaskLink](docs/TaskLink.md)
 - [Team](docs/Team.md)
 - [TeamMember](docs/TeamMember.md)
 - [User](docs/User.md)
 - [UserFollow](docs/UserFollow.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issues.

## Author

Sandeep Khanna 