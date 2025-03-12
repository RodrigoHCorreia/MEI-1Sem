# Segurança de Redes e Sistemas de Computadores

## How to define a secure system: **There's still not a good definition**

- A system that was never revealed to be insecure or unsafe in its use
- A system that always performed correctly
- A system that never revealed vulnerabilities
- A system that has never been attacked

All these deficiotions say is that **there are no secure systems**

How can we measure RISK?

**RISK**(t) = Vulnerability(t) * Threat potential(t) - both depend on time
**SOC** - Security Operation Center

The amount of protection affoarded to an automated information system in order to attain the applicable **objectives of preserving security properties** of information system resources, including hardware, software, firmware, information/data and communications - Defined by NIST.

Network security - communications

Computer systems security - hardware and software

## How How to define Security Objectives and Security Properties?

Security framework - structured set of guidelines together with stardards and best practices that provide a systematic approach to indetifying assess and addressing security risks, ensuring the protection of critical assets (data, systems, networks) from threats (cyberattacks or data breaches).

Confidentiality
Integrity
Availability


Authentication
Confidentiality
Access Control
Nonrepudiation
Data integrity

**System Integrity** - the system performs its intended function in an unimpaired manner, free from deliberate or inadvertent unauthorized manipulation of the system.

**Nonrepudiation** - the ability to prove that a specific user performed a specific action

Peer-Authentication - proof of identity of the peer
Data-Origin (Message) Authentication - proof of the origin of the data (maybe the origin is not the direct peer)

TOR network - provides anonymity

VPN / IPSEC - provides confidentiality via tunneling

Notion of Accountability

- Registration Logging & Auditing Trails of all events and actions of entitites, traced and preserved under integrity guarantees:
  - Non repudiable
  - Deterrence
  - Faults, errors, critical events, actions under security conditions
  - Isolation
  - Events from intrusion preventions, detection, and response systems
  - All events from legal and regulatory compliance audits
- Required and relevant support for security forensics analysis and systems' maintainability

Virtualization is an isolation technology.
Containers are also an isolation technology, but in another level.

## A systematic approach to security

- All systems designed without a Adversary Model are for sure not secure systems.

Adversary Model - threats, threat agents(who), risk, attack typology, exploits, etc. basically understanding the enemy.

- Start to define the adversary model.
- Define the security objectives (countermeasures) - what are the security properties that we want to achieve.
- Design the security services (Ex. Functions, controls, protocols)
- Implement the security services with correct and verifiable security mechanisms (as building blocks)
- Specific mechanisms - encryption, authentication, access control, etc. 
- And Pervasive Mechanisms - logging, auditing, monitoring, etc.
