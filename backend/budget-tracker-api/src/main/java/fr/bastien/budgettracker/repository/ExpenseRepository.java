package fr.bastien.budgettracker.repository;

import fr.bastien.budgettracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
