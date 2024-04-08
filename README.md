## Design Problem

You are in charge of making the lines at airport security run smoothly. Every day thousands of people pass through security. There are 3 main types of people who go through this line: economy class passengers, VIP passengers, and flight staff. There is one line but some people have the ability to cut through. The system should allow VIPs and flight staff go straight to the scanners. They are rare occurrences and only appear 1 in every 100 people.


## Clarifications or Questions

- Do Flight Staff has priority over VIP?
- How should the system handle individuals with the same priority (e.g., two VIPs arriving at the same time)?
- Does the system need to be thread safe to prevent potential issues like race conditions?
- What is the expected maximum size of the queue, and are there any performance constraints?
- How flexible does the system need to be to accommodate future changes, such as adding new types of passengers?

## Design Decisions and Assumptions

- **Assumption:** Priority Order: FLIGHT STAFF then VIP then ECONOMY 
- **Data Structure:** The ideal ADT is a Priority Queue. It allows prioritizing elements so that Flight Staff are given prioirty over VIP, and VIP are given priority over Ecnonomy passengers, even if they arrive later. If the same type of people are in the queue they are processed in FIFO order.
- **Tie-breaking:** If two persons have the same priority, they are processed based on their arrival order.
- **Simplicity:** The system is designed for a single security line. If multiple lines are needed, the design can be extended to manage multiple `SecurityLine` instances.
- **Extensibility:**  If additional priority levels are needed, the `PersonType` enum can be extended.