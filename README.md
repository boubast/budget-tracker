# Budget Tracker

Budget Tracker est un projet personnel de développement fullstack réalisé dans un objectif d’apprentissage.

Le but est de progresser concrètement sur un stack utilisé en entreprise :

- Java
- Spring Boot
- Angular
- PostgreSQL
- API REST
- Tests
- Git
- Architecture propre

L’objectif n’est pas de créer une application révolutionnaire, mais de construire un projet complet, maintenable et réaliste, proche d’un vrai contexte professionnel.

## Objectifs du projet

Ce projet me sert à travailler :

- la conception d’une API REST propre avec Spring Boot
- la séparation Controller / Service / Repository
- l’utilisation de DTO pour éviter d’exposer directement les entités JPA
- la persistance des données avec PostgreSQL
- la validation des données côté backend
- la gestion propre des erreurs
- la création d’une interface Angular connectée à une API
- les formulaires Angular
- les appels HTTP avec HttpClient
- les tests backend avec JUnit et Mockito
- la documentation d’un projet technique
- les bonnes pratiques Git et README

## Fonctionnalités prévues

### Version initiale

- Ajouter une dépense
- Modifier une dépense
- Supprimer une dépense
- Lister les dépenses
- Voir le détail d’une dépense

### Évolutions prévues

- Catégoriser les dépenses
- Filtrer les dépenses par mois
- Afficher le total mensuel
- Importer un fichier CSV bancaire
- Ajouter un tableau de bord
- Ajouter des tests automatisés
- Ajouter Docker
- Préparer une documentation technique propre

## Stack technique

### Backend

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Bean Validation
- JUnit
- Mockito

### Frontend

- Angular
- TypeScript
- HttpClient
- Reactive Forms
- RxJS

### Outils

- Git
- GitHub
- IntelliJ IDEA
- VS Code
- Insomnia ou Postman
- PostgreSQL
- Docker, plus tard

## Architecture visée

### Backend

```text
src/main/java/fr/bastien/budgettracker
├── controller
├── service
├── repository
├── entity
├── dto
├── mapper
├── exception
└── config
