# CLAUDE.md — Repo Conventions

Personal academic archive for Omkar Gajare (UID: 2025300063) at SPIT, CE 2023-27 batch.

---

## Folder Structure

```
college/
├── FY (2025-26)/          ← Academic year folder
│   ├── PSIPL/             ← Subject folders at top level
│   ├── PSOOP/
│   ├── EG/
│   └── TS/
├── SY (2026-27)/          ← Subject folders directly under year
│   └── DS/                ← Only subject with content so far
├── _template/             ← Copy README.md from here when starting a new subject
├── ce-syll-2023-27.pdf    ← Full SPIT CE curriculum (2023-27 batch)
├── CLAUDE.md              ← This file
├── README.md
├── .gitignore
└── .gitattributes         ← Git LFS tracking rules for binary files
```

---

## Curriculum Quick Reference (CE 2023-27 Batch)

| Sem | Code  | Subject |
| :-: | :---: | :------ |
| I   | CE101 | Problem Solving using Imperative Programming Lab (PSIPL) |
| I   | AS105 | Engineering Graphics (EG) |
| I/II | AS106 | Tech Shop (TS) |
| II  | CE102 | Problem Solving using Object Oriented Programming Lab (PSOOP) |
| III | CE201 | Discrete Structures and Graph Theory (DSGT) |
| III | CE202 | Data Structures (DS) |
| III | CE203 | Computer Organization and Architecture (COA) |
| III | CE204 | Database Management Systems (DBMS) |
| IV  | CE205 | Statical Methods in Computer Science |
| IV  | CE206 | Operating Systems (OS) |
| IV  | CE207 | Design and Analysis of Algorithms (DAA) |
| IV  | CE208 | Computer Communications and Networks (CCN) |
| V   | CE301 | Distributed Computing (DC) |
| V   | CE302 | Software Engineering (SE) |
| V   | CE303 | Artificial Intelligence and Soft Computing (AI) |
| V   | CE304 | Theory of Computation (TC) |
| V   | CE305 | Cryptography and Network Security (CNS) |
| VI  | CE306 | System Programming and Compiler Construction (SPCC) |
| VI  | CE307 | Machine Learning (ML) |
| VI  | CE308 | DevOps Lab |

Full syllabus: `ce-syll-2023-27.pdf`

---

## Adding a New Subject

1. Create the subject folder under the correct year path (e.g. `SY (2026-27)/DSGT/`).
2. Copy `_template/README.md` into it and fill in the course details.
3. Add a row to the year-level `README.md` table (create one if needed).
4. Add a link in the root `README.md` under the correct year heading.
5. Commit: `git add <subject-folder> && git commit -m "add <SUBJ> skeleton"`

---

## Git Rules

### What is NOT committed (covered by .gitignore)
- `.DS_Store` — macOS metadata
- `.vscode/`, `.idea/` — IDE config
- `*.cbp`, `*.layout` — CodeBlocks project files
- `package.bluej` — BlueJ project metadata
- `.github/copilot-instructions.md` — AI assistant config (per-folder)
- `.ctxt` — BlueJ editor state
- `*.o`, `*.exe`, `*.class` — compiled output
- `obj/`, `bin/` — build output directories

### Binary files (Git LFS)
Large binary files (PDFs, Word docs, AutoCAD drawings, Blender files) should use Git LFS. The rules are already set in `.gitattributes`.

**To activate LFS** (one-time setup, needs `git-lfs` installed):
```bash
brew install git-lfs
git lfs install
# Re-add any already-committed binaries:
git lfs migrate import --include="*.pdf,*.docx,*.dwg,*.blend" --include-ref=refs/heads/main
git push --force
```

### Commit message style
```
add <SUBJ> week <N> turn <N>         # new assignment
fix <SUBJ>/<file>: <what was wrong>  # correction
update README: <what changed>        # doc-only change
cleanup: remove build artifacts      # housekeeping
```

---

## File Naming Convention

Submitted documents: `ROLLNUMBER_Name_AssignmentN_TurnN.ext`
Example: `2025300063_OmkarG_Assignment1_Turn1.pdf`

Source code folders: `a<week>_t<turn>_<question>` (BlueJ style) or flat `.c` files for PSIPL.

---

## Subject README Links

Always use **relative links** in subject READMEs (e.g. `./Week%201/Turn%201/`), not absolute paths starting with `/`. Relative links survive folder renames and restructures.

Root and year READMEs use absolute paths (e.g. `/FY%20(2025-26)/PSIPL`) since they link across the tree.
