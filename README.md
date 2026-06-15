# Learning Java -- NS Marine Rescue

A Java 21 console application for tracking marine animal rescues — from initial sighting through rehabilitation and release. Built as a structured learning project covering core Java concepts, software architecture patterns, and concurrency.

## Overview

The system manages the full lifecycle of marine animal rescue cases:

```
Reported Seal → Rescue Case Created → Assigned for Rescue → Rehabilitation Updates → Released
```

Key domain objects include animals, rescue cases, observations, and volunteers.

## Architecture

```
src/main/java/com/marinerescue/
├── model/          # Domain objects (Animal, RescueCase, Observation, Volunteer)
├── controller/     # User input handling, delegates to services
├── view/           # Console output and menus
├── service/        # Business logic layer
├── repository/     # Data access layer (in-memory storage)
├── threading/      # Concurrency (dispatch queue, workers, notifications)
├── export/         # Export strategies (CSV, JSON)
└── validation/     # Input validators
```

## Tech Stack

- **Java 21** (LTS)
- **Maven** for build and dependency management
- **JUnit 5** for unit testing

## Getting Started

### Prerequisites

- Java 21 JDK
- Maven 3.8+

### Build and Run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.marinerescue.Main"
```

### Run Tests

```bash
mvn test
```

## Features

- Register and track marine animals by species, age, and health status
- Open rescue cases with location and timestamp tracking
- Assign volunteers to active cases
- Record timestamped observations throughout rehabilitation
- Advance case status through a defined lifecycle
- Export case data in CSV or JSON format
- Background dispatch queue for rescue coordination
- Periodic statistics reporting
- Async notifications on status changes

## Learning Objectives

This project is structured across 25 gihub issues to teach:

| Project Setup | Maven, packages, Java project structure |
| Domain Models | Classes, encapsulation, enums, composition, collections |
| Repository Layer | Interfaces, generics, HashMap, Stream API |
| Service Layer | Constructor injection, business logic separation |
| MVC Console | Scanner input, view/controller separation, main loop |
| SOLID Refactoring | SRP, OCP (Strategy Pattern), LSP, ISP, DIP |
| Multithreading | BlockingQueue, ExecutorService, ScheduledExecutor, CompletableFuture, synchronized, ReentrantLock |
| Testing | JUnit 5, AAA pattern, assertions, test isolation |

## Branch Strategy

| `feature/project-setup` | Initial project scaffolding |
| `feature/animal-model` | All domain models |
| `feature/repository-layer` | Interfaces and in-memory implementations |
| `feature/service-layer` | AnimalService, RescueService |
| `feature/mvc-console` | ConsoleView, RescueController, full wiring |
| `feature/solid-refactor` | Validator extraction, export strategies, animal hierarchy, ISP, DIP |
| `feature/dispatch-queue` | Producer-consumer queue, ExecutorService |
| `feature/statistics-worker` | Scheduled stats, notifications, race condition exercise |
| `feature/testing` | JUnit 5 test suites |

## Project Status

**Estimated Duration:** 20-25 hours

See repo issues for the full backlog with detailed acceptance criteria and code examples.
