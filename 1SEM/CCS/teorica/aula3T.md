# SCC

## Web Applications

Usually deployed using a three-tier architecture:

- **Client Tier** - The user interface. (presentation)
- **Application tier** - The logic of the application. (business)
- **Data tier** - The data storage.

**Data tier:**
We will use BLOB storage for the videos and sql databases and key-value to store the users and then compare the results to see if its superior or not.
Other services: caches, message queues, etc.

**Reasons for having multiple server instances:**

- A single server might not sufice all the requests. (limited throughput)
- 1 server is a single point of failure. if it fails the service becomes unavailable (limited availability)
- A single server may be too far for some clients; (inadequate latency)

To accomplish this we need to have a load balancer that will distribute the requests to the servers. 
Also the servers need to be stateless, so that the load balancer can distribute the requests to any server, without having to worry about the state of the server.

Azure - Web app service
Google - App Engine
AWS - Elastic Beanstalk

## App Service

- App Service handles HTTP/REST requests
- Use database/storage services for durability
- Use cache services for performance
- Use CDN for reducing load time and save bandwidtch

App Service is a PaaS service that allows you to deploy and scale web applications.

## Blob Storage Service

- Store and serve large amounts of unstructured data.
- Store video, audio, images, etc.
- Store backups, logs, etc.

Blob storage offers:
- The storage account
- Containers
- Blobs

3 Types of blobs:
- Block blobs - stores text and binary data, up to 190TB.
- Append blobs - made up of blocks optimized for append operations. this can be used to store logs.
- Page blobs - some random access files up to 8 TB in size. Page blobs store virtual hard drive files and serve as disks for Azure VMs.

## Access Tiers

- Hot - optimized for frequent access. more expensive
- Cool - optimized for infrequent access. cheaper
- Archive - optimized for rare access. cheapest