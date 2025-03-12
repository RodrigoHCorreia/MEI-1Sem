# Cloud Computing Systems

**Sérgio Duarte**
mail: smd_at_fct.unl.pt

- Cloud Computing Infrastructures have become pervasive for creating new online applications and services:
- Reliability, Scalibility, and Performance

**Cloud Computing:** - The practice of using a network of remove servers hosted on the internet.

**Cloud Computing** is a model for enabling ubiquitous (always available), convenient, on-demand network access to a shared pool of configurable **computing** resources.

## Public vs Private Cloud Services

- **Public Cloud Services** - Offered by third-party providers over the public internet, making them available to anyone who wants to use or purchase them.

- **Private Cloud Services** - Operated solely for a single organization, whether managed internally or by a third-party, and hosted either internally or externally.

## Types of Cloud Services

There are three main types of cloud services: and they are distinguished by the level of abstraction they provide, from the lowest level to the highest level.

- **IaaS (Infrastructure as a Service)** - Provides **virtualized computing** resources over the internet. e.g. VMs, disks, etc.
  - Amazon (EC2); Google (Compute Engine); Microsoft (Azure)

- **PaaS (Platform as a Service)** - Provides a **platform allowing customers to develop, run, and manage applications** without the complexity of building and maintaining the infrastructure. e.g. databases, queues, etc.
  - Google (App Engine); Microsoft (Azure); Heroku

- **SaaS (Software as a Service)** - Provides **software applications** over the internet on a subscription basis. e.g. email, office software, etc.
  - Google (Gmail); Microsoft (Office 365); Salesforce

- Computing as a utility - Only pay for what you use.
- No minimum or up-front payment
- Use what you need.

Helpful for apps with variable utilization, this way you can scale up or down as needed, and will be cheaper than having a dedicated server that you're not using all the time.

- Enables eslasticity (start small and grow as needed)
- Allows servers in multiple regions, making it possible to deliver low latency.

**Some challenges:**
- How do you avoid having many customers spiking at the same time?
- How to encourage customers to use resources when demand is low? 
- E.g.: Amazon Spot Instances - much lower prices but instances can be terminated at any time if needed.

