# Roadmap du projet Budget Tracker

Ce fichier décrit les itérations prévues pour construire progressivement l’application.

Chaque étape doit être validée avant de passer à la suivante.

---

## Itération 0 — Initialisation du projet

Objectif : créer une base propre pour le projet.

### À faire

- [X] Créer le repository GitHub
- [X] Ajouter un `README.md`
- [X] Ajouter un `ROADMAP.md`
- [ ] Créer le projet Spring Boot
- [ ] Nommer le projet `budget-tracker-api`
- [ ] Utiliser le package `fr.bastien.budgettracker`
- [ ] Ajouter les dépendances backend :
  - [ ] Spring Web
  - [ ] Spring Data JPA
  - [ ] PostgreSQL Driver
  - [ ] Validation
  - [ ] Lombok
- [ ] Vérifier que l’application démarre
- [ ] Faire un premier commit propre

### Résultat attendu

Le projet backend démarre sans erreur.

---

## Itération 1 — Première entité Expense

Objectif : créer le premier modèle métier.

### À faire

- [ ] Créer le package `entity`
- [ ] Créer la classe `Expense`
- [ ] Ajouter les champs :
  - [ ] `id`
  - [ ] `label`
  - [ ] `amount`
  - [ ] `date`
  - [ ] `category`
- [ ] Ajouter les annotations JPA :
  - [ ] `@Entity`
  - [ ] `@Id`
  - [ ] `@GeneratedValue`
- [ ] Utiliser `BigDecimal` pour le montant
- [ ] Utiliser `LocalDate` pour la date
- [ ] Vérifier que le projet compile

### Résultat attendu

L’entité `Expense` existe et représente une dépense simple.

---

## Itération 2 — Repository

Objectif : connecter l’entité à la base de données.

### À faire

- [ ] Créer le package `repository`
- [ ] Créer `ExpenseRepository`
- [ ] Étendre `JpaRepository<Expense, Long>`
- [ ] Configurer PostgreSQL dans `application.properties` ou `application.yml`
- [ ] Créer la base PostgreSQL
- [ ] Vérifier que la table est créée automatiquement en développement
- [ ] Tester le démarrage de l’application

### Résultat attendu

Spring Boot peut accéder aux dépenses via JPA.

---

## Itération 3 — Service

Objectif : placer la logique métier dans une couche dédiée.

### À faire

- [ ] Créer le package `service`
- [ ] Créer `ExpenseService`
- [ ] Injecter `ExpenseRepository` par constructeur
- [ ] Créer les méthodes :
  - [ ] `findAll`
  - [ ] `findById`
  - [ ] `create`
  - [ ] `update`
  - [ ] `delete`
- [ ] Gérer le cas où une dépense n’existe pas
- [ ] Ne pas mettre de logique métier dans le controller

### Résultat attendu

Toutes les opérations CRUD sont disponibles dans le service.

---

## Itération 4 — Controller REST

Objectif : exposer l’API HTTP.

### À faire

- [ ] Créer le package `controller`
- [ ] Créer `ExpenseController`
- [ ] Ajouter `@RestController`
- [ ] Ajouter `@RequestMapping("/api/expenses")`
- [ ] Créer les routes :
  - [ ] `GET /api/expenses`
  - [ ] `GET /api/expenses/{id}`
  - [ ] `POST /api/expenses`
  - [ ] `PUT /api/expenses/{id}`
  - [ ] `DELETE /api/expenses/{id}`
- [ ] Tester les routes avec Insomnia ou Postman
- [ ] Vérifier les codes HTTP retournés

### Résultat attendu

L’API permet de créer, lire, modifier et supprimer des dépenses.

---

## Itération 5 — DTO

Objectif : arrêter d’exposer directement les entités JPA.

### À faire

- [ ] Créer le package `dto`
- [ ] Créer `ExpenseDto`
- [ ] Créer `CreateExpenseRequest`
- [ ] Créer `UpdateExpenseRequest`
- [ ] Adapter le controller pour recevoir des DTO
- [ ] Adapter le service pour retourner des DTO
- [ ] Vérifier que l’entité `Expense` n’est plus exposée directement

### Résultat attendu

L’API communique avec le frontend uniquement via des DTO.

---

## Itération 6 — Mapper

Objectif : isoler la conversion entre Entity et DTO.

### À faire

- [ ] Créer le package `mapper`
- [ ] Créer `ExpenseMapper`
- [ ] Ajouter une méthode `toDto`
- [ ] Ajouter une méthode `toEntity`
- [ ] Ajouter une méthode pour mettre à jour une entité existante
- [ ] Supprimer les conversions manuelles du controller
- [ ] Garder le service lisible

### Résultat attendu

Les conversions sont centralisées dans un mapper.

---

## Itération 7 — Validation

Objectif : empêcher les données invalides d’entrer dans l’application.

### À faire

- [ ] Ajouter `@Valid` dans le controller
- [ ] Ajouter des contraintes dans les DTO :
  - [ ] `@NotBlank` sur le libellé
  - [ ] `@NotNull` sur le montant
  - [ ] `@Positive` sur le montant
  - [ ] `@NotNull` sur la date
  - [ ] `@NotBlank` sur la catégorie
- [ ] Tester les erreurs de validation
- [ ] Vérifier les réponses HTTP en cas de mauvaise requête

### Résultat attendu

L’API refuse les dépenses invalides.

---

## Itération 8 — Gestion d’erreurs propre

Objectif : retourner des erreurs claires côté API.

### À faire

- [ ] Créer le package `exception`
- [ ] Créer `ExpenseNotFoundException`
- [ ] Créer un `GlobalExceptionHandler`
- [ ] Ajouter `@RestControllerAdvice`
- [ ] Gérer les erreurs :
  - [ ] ressource introuvable
  - [ ] validation invalide
  - [ ] erreur serveur générique
- [ ] Retourner un format d’erreur propre

Exemple attendu :

```json
{
  "status": 404,
  "message": "Expense not found",
  "timestamp": "2026-05-10T18:00:00"
}
