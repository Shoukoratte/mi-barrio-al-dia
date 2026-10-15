# ADR-003: Repository Strategy — Conventional Monorepo

**Status:** Proposed  
**Date:** 2026-10-14  
**Project:** Mi barrio al día

## Context

Mi barrio al día is a community reporting platform initially targeting Barranquilla, Colombia.

The initial technical stack consists of:

- React and TypeScript for the frontend.
- Java and Spring Boot for the backend.
- PostgreSQL and PostGIS for data persistence and geospatial capabilities.
- Python and SQL for potential future data engineering workflows.

The team is small, includes developers with different experience levels, and operates under a zero-cost development budget.

We need a repository structure that supports collaboration, independent development, documentation, testing, and future deployment without introducing unnecessary tooling complexity.

## Decision

We propose adopting a conventional monorepo with clearly separated directories:

- `frontend/`: React application.
- `backend/`: Spring Boot application.
- `data/`: Future data processing tools and scripts.
- `docs/`: Project documentation and architecture decisions.
- `.github/workflows/`: CI/CD workflows.

The frontend will use npm and Vite.

The backend will use Maven.

The repository will initially use GitHub Actions for automation without adopting Nx, Turborepo, or another monorepo orchestration framework.

The backend will follow a modular monolith approach, with internal boundaries between business capabilities.

The frontend and backend may be built, tested, and deployed independently.

## Alternatives Considered

### Separate repositories (Polyrepo)

**Advantages:**
- Independent repository permissions and lifecycle.
- Clear repository-level boundaries.

**Disadvantages:**
- Increased coordination overhead for a small team.
- Cross-component changes require multiple repositories.
- Documentation and project setup are distributed.

### Nx

**Advantages:**
- Task orchestration and caching.
- Dependency-aware project workflows.
- Useful tooling for larger monorepos.

**Disadvantages:**
- Additional setup and learning requirements.
- Benefits may be limited for the initial project size.
- Java-specific workflows require additional evaluation.

### Turborepo

**Advantages:**
- Task orchestration and caching.
- Effective tooling for JavaScript and TypeScript workspaces.

**Disadvantages:**
- Additional configuration for the Java backend.
- Limited immediate benefit for one frontend and one backend.

## Consequences

### Positive

- All application code and documentation remain in one repository.
- Contributors can review changes across components.
- Initial setup remains understandable.
- The project avoids unnecessary infrastructure and tooling costs.
- Independent frontend and backend workflows remain possible.

### Negative

- Repository-level access is shared across components.
- CI workflows must explicitly handle multiple technologies.
- The repository may become more complex as the project grows.
- Build caching and affected-project detection will initially require manual configuration if needed.

## Reconsideration Criteria

We will revisit this decision if:

- Multiple frontend or backend applications are introduced.
- Build or test times become a recurring bottleneck.
- Shared libraries require coordinated versioning.
- CI workflows become difficult to maintain.
- A tool such as Nx or Turborepo demonstrates measurable benefits for our actual workflows.

## Current Outcome

**Proposed — pending project lead acceptance and asynchronous contributor feedback.**

No Nx or Turborepo dependency will be introduced during initial repository setup.
