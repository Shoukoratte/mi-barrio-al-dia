# Mi barrio al día

**A community-driven platform for reporting, exploring, and tracking neighborhood issues in Barranquilla, Colombia.**

**Languages:** English | [Español](README.es.md)

## About the Project

**Mi barrio al día** is an open-source community platform designed to help residents identify, document, and explore everyday issues affecting their neighborhoods.

The project begins in Barranquilla, Colombia, with the long-term vision of making community information more accessible, transparent, and useful.

Residents will be able to report issues, attach supporting evidence, and explore community-submitted information through an interactive neighborhood map.

> **Project status:** Discovery and MVP planning. The application is not yet available for public use.

## The Problem

Neighborhoods frequently experience issues such as:

- Broken or stolen streetlights.
- Accumulated garbage.
- Dead animals in public spaces.
- Damaged sidewalks.
- Blocked or deteriorated roads.

These situations may remain undocumented or be discussed only through informal channels.

Our goal is to provide an accessible way to document and visualize these problems while encouraging community participation.

## Proposed Features

### Minimum Viable Product (MVP)

- Interactive map with neighborhood boundaries.
- Community issue reporting.
- Issue categories and descriptions.
- Manual location selection or optional device geolocation.
- Approximate public location display.
- Supporting photographic evidence.
- Neighborhood-based report exploration.
- Basic issue details and status information.

The final MVP scope is still being validated.

### Planned Enhancements

- Community confirmations and report history.
- Neighborhood statistics and data analytics.
- Community safety perception indicators.
- Guidance toward official emergency and police assistance channels.
- Assistance preparing formal PQRSD requests.
- Additional accessibility and moderation capabilities.

## Technology Stack

| Layer | Technology |
|---|---|
| Frontend | React, TypeScript, Vite |
| Backend | Java, Spring Boot |
| Database | PostgreSQL, PostGIS |
| Interactive Maps | Leaflet |
| Data Engineering | Python, SQL |
| Testing | JUnit, Playwright |
| Version Control | Git, GitHub |
| CI/CD | GitHub Actions |

These technologies represent our current architectural direction and may evolve as requirements are validated.

## Architecture

The initial architecture follows a modular full-stack approach:

```text
Citizen / Web Browser
          |
          v
 React + TypeScript
          |
          | REST API / JSON
          v
   Java + Spring Boot
          |
          v
  PostgreSQL + PostGIS
```

Data analytics and additional integrations will be introduced incrementally when justified by actual product requirements.

## Project Principles

- **Community first:** prioritize real neighborhood needs.
- **Privacy by design:** protect users and avoid unnecessary exposure of precise locations or personal information.
- **Transparency:** clearly distinguish community submissions from verified official responses.
- **Security:** apply validation, access controls, and abuse prevention.
- **Accessibility:** Spanish-first interface with planned English support.
- **Continuous learning:** document technical decisions, trade-offs, and lessons learned.
- **Zero-cost development:** prioritize free and open-source tools during the initial stages.

## Important Disclaimer

Mi barrio al día is an independent community initiative.

It is **not an official government reporting platform**, does not automatically submit formal complaints or petitions, and does not replace emergency services.

Community-submitted information must not be interpreted as officially verified information.

## Development Approach

The project uses an iterative, milestone-based workflow inspired by Agile and Kanban practices.

Work will be organized through GitHub Issues and Pull Requests, with defined acceptance criteria and code reviews.

The initial milestones are:

1. Product discovery and requirements.
2. Architecture and development environment.
3. Core reporting and interactive mapping.
4. Security, testing
