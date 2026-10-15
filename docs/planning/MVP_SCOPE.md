# Mi barrio al día — MVP Scope

**Document ID:** DISC-MVP-001  
**Version:** 0.9 (team review candidate)  
**Status:** Proposed — pending team review and approval  
**Product area:** Barranquilla, Colombia  
**Initial pilot area:** San Roque (proposed; boundary data and suitability pending validation)

## 1. Objective

Validate whether residents can conveniently document everyday public-space issues with structured information and subsequently find published community reports on an interactive neighborhood map.

This is a community information product, **not** an official complaint filing system or emergency-response service.

## 2. Evidence and assumptions

Five people who live in or frequently travel through Barranquilla were interviewed informally. They mentioned repeated streetlight problems, accumulated garbage, dead animals in public space, interest in neighborhood-level issue maps and statistics, and concerns around perceived safety. These interviews are directional qualitative input, not representative research or proof of product-market fit.

**To validate:** how people report issues today, actual willingness to submit a report, accessibility barriers, moderation capacity, and practical suitability of the pilot neighborhood.

## 3. Intended users

| User | Needs | Access |
| --- | --- | --- |
| Visitor | Browse neighborhood and approved issue reports | Public (no account) |
| Registered resident | Submit issues and review their own submissions | Authenticated |
| Moderator | Review pending submissions and approve or reject them | Authorized role |
| Administrator | Manage moderator access and investigate operational issues | Restricted role; minimal functions initially |

## 4. Core MVP workflow

1. A visitor opens the map and selects the pilot neighborhood.
2. They browse published reports and report details.
3. To create a report, they authenticate.
4. They select a category, describe the issue, and provide a location manually or (optionally) via device geolocation; the chosen point can be adjusted.
5. Locally, they may add photographic evidence, subject to type/size validation, safe image re-encoding, and metadata removal.
6. Submission creates a report in `PENDING_REVIEW`, not visible in public views.
7. A moderator reviews and approves or rejects it, recording the decision and a reason for rejection.
8. Only approved reports are shown publicly, with an approximate location and a clear community-information label.
9. The author can view the moderation outcome of their submission.

Approving publication means a report complies with platform rules; it does **not** certify the truth of the incident or constitute an official response.

## 5. In scope — functional requirements

| ID | Capability | MVP requirement |
| --- | --- | --- |
| MAP-001 | Pilot neighborhood map | Display an interactive map and selectable neighborhood boundary, subject to geodata rights and quality verification. |
| MAP-002 | Neighborhood panel | Show published reports, counts, categories, and access to report detail. |
| REPORT-001 | Report creation | Category, description, timestamps, location, and authorship. |
| GEO-002 | Location selection | Manual map pin or explicit opt-in browser location; pin editable; approximate public coordinates. |
| AUTH-001 | Identity | Public browsing; authenticated report submission. Google OIDC through Spring Security is a **candidate** pending proof of concept. |
| REPORT-002 | Author status | Authors can see pending, approved, or rejected status for their reports. |
| MOD-001 | Review queue | Authorized moderators can inspect pending submissions. |
| MOD-002 | Decision | Moderators approve or reject; rejections require a reason; log actor and timestamp. |
| EVID-001 | Local photo evidence | Validated photo upload and local storage for development/testing only. |
| I18N-001 | Language-ready UI | Spanish (`es-CO`) default, English planned; translation-friendly keys and identifiers. |

**Initial report categories (proposed):** broken public lighting, accumulated garbage, dead animals in public space, damaged sidewalks, blocked/damaged roads. Category list requires final team review.

## 6. Explicit separation: local MVP vs. public demo

### Local development / testing
- Implement photographic uploads and local persistent storage in a controlled environment.
- Reject unexpected file types and oversized uploads; inspect and safely re-encode accepted images, strip metadata, avoid trusting user-supplied filenames, and restrict access to unpublished evidence.
- Use synthetic or consented test data; avoid storing sensitive photos in the repository.

### Public portfolio demo (zero-budget objective)
- Display **predefined, synthetic sample reports and images**; clearly label them as demo data.
- **Disable public user-generated image uploads**, unless persistent storage and moderation safeguards are independently verified and approved.
- Do not claim to operate a reliable public reporting service or expose unmoderated submissions.
- Public demo mode may restrict submission to demo accounts or use disposable test data; this behavior must be selected before deployment.

### Future community pilot
- Real public submissions and photos require a separate go/no-go review of hosting/storage costs, privacy notices, consent, retention/deletion, abuse prevention, backups, moderation staffing, and operational response.

## 7. Out of scope for initial MVP

- Crime/robbery incident reports and public accusation maps.
- Neighborhood safety perception scores (research backlog, distinct from crime rates).
- Live CAI search, dispatch, or emergency handling.
- Automatic filing or status synchronization with official PQRSD systems.
- Generated PQRSD request drafts (approved product direction, **deferred from initial MVP**).
- Advanced analytics, data warehouse, pipelines, and dashboards.
- Public community confirmations and full public change history.
- Push notifications, gamification, advanced trust scores, automated AI moderation.
- Citywide production rollout and guaranteed response/resolution times.

## 8. Key non-functional requirements

**Security:** enforce authorization in backend; owner checks; validate input; protect sessions, CSRF where applicable, and sensitive endpoints; limit abusive traffic; no credentials in Git.

**Privacy:** minimize personal data; do not publish account identity or precise device location; permit location denial without blocking manual reporting; avoid exposing pending evidence; prepare appropriate Colombian personal-data documentation before live registration.

**Accessibility:** keyboard-accessible core workflows, semantic labels, responsive design, non-map alternative where feasible, Spanish-first UX.

**Quality:** unit, integration, and end-to-end tests for core flows; reproducible local setup; document deployment limitations.

**Budget:** US$0 required for learning and initial portfolio demo; no unapproved paid plans or billing-enabled services.

## 9. Acceptance criteria — MVP completion

- [ ] A visitor can select the pilot neighborhood and see only approved synthetic or permitted public reports.
- [ ] A non-authenticated visitor cannot submit a new report through either frontend or direct API requests.
- [ ] An authenticated user can create a report with required valid fields and manually selected location.
- [ ] Device location is requested only after an explicit user action, and can be refused without blocking manual selection.
- [ ] A newly submitted report is `PENDING_REVIEW` and unavailable through public report endpoints.
- [ ] A moderator can approve or reject a pending report; a rejection records a reason.
- [ ] Unauthorized users cannot moderate or access unpublished reports belonging to others.
- [ ] An approved report is visible on the map with a suitably approximate public location and community label.
- [ ] The author can view their submission and its moderation outcome.
- [ ] Local photo uploads enforce limits and safety controls; public demo uploads are disabled pending an approved persistence design.
- [ ] Core workflows have automated tests and are demonstrable using documented setup steps.
- [ ] Team review confirms the pilot's geographic data source is suitable and legally reusable.

## 10. Risks and mitigations

| Risk | Impact | Initial mitigation |
| --- | --- | --- |
| Volunteer moderation backlog | Slow publication | Clear `PENDING_REVIEW` status; narrow pilot and test volume; no promised SLA |
| False, defamatory, or sensitive submissions | Harm to people or neighborhoods | Prior moderation, takedown procedure, no crime allegation category |
| Precise location / photo metadata leaks | Privacy harm | Approximate public location, strip metadata, restrict unpublished files |
| OAuth and free hosting constraints | Login/demo failures | Local proof of concept; verify callback URLs, sessions, and free-tier behavior |
| No durable free image storage | Lost data or unexpected expense | Local images only; fixed demo media; no billing activation |
| Unverified neighborhood boundaries | Incorrect reporting | Validate data provenance, licensing, boundaries, and edge cases |
| PQRSD confusion | Citizens assume official processing | Explicit disclaimers; no automatic filing |

## 11. Technology direction (not all approved architecture)

- **Frontend:** React + TypeScript + Vite; Leaflet for maps.
- **Backend:** Java + Spring Boot + Spring Security, REST API.
- **Database:** PostgreSQL + PostGIS.
- **Identity candidate:** Google OpenID Connect via Spring Security, pending technical feasibility assessment and final ADR.
- **Repository:** single monorepo using Maven for Java and npm for React initially; Nx/Turborepo not yet justified.
- **Quality & delivery:** JUnit, frontend tests, Playwright, GitHub Actions incrementally.
- **Later data engineering:** Python and SQL pipelines using aggregated, privacy-conscious datasets.

## 12. Initial work milestones

1. **M1 — Scope approval:** review interviews, confirm pilot neighborhood and categories, accept MVP requirements and risks.
2. **M2 — Architecture proof:** validate geodata source, auth approach, API contract and core data model.
3. **M3 — Vertical slice:** map → login → create report → moderation → public report display.
4. **M4 — Local evidence & quality:** safe local images, automated tests, security and accessibility reviews.
5. **M5 — Portfolio demo:** synthetic data, clear demo limitations, deployment without mandatory cost, README and technical documentation.

Work is managed through GitHub Issues/Projects. The team currently estimates 42 hours/week combined availability (30 + 6 + 6); milestone dates will be forecast after observing actual throughput, not promised in advance.

## 13. Decisions and open questions

**Accepted product decisions**
- Reporting public-space problems is the primary product value.
- Public browsing; account required to submit reports.
- Moderator approval before public visibility.
- Manual pin and optional explicit geolocation.
- Photos work locally; the initial public demo uses predefined images, not public image uploads.
- Spanish-first, with English support as product direction.

**Open for team review**
- Final choice and configuration of Google Sign-In and user onboarding.
- Pilot boundary data provenance, license and fitness.
- Detailed registration/privacy notice and account deletion flow.
- Final category list and report edit/withdrawal rules.
- Moderation policy, appeals, report retention and takedown procedures.
- Demo mode behavior: read-only vs. disposable sandbox submissions.
- Exact free-tier hosting feasibility at deployment time.

## 14. Approval record

| Role | Approval | Date |
| --- | --- | --- |
| Project lead | Pending | — |
| Frontend contributor | Pending | — |
| Junior contributor | Pending | — |

**Exit criterion for DISC-MVP-001:** this document is reviewed, updated if needed, approved by the team, and linked from the GitHub Issue. Until then, this is a candidate scope, not a completed issue.
