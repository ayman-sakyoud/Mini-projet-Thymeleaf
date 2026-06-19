# 💻 Mini Projet : Parc Informatique (Thymeleaf)

Système de gestion d'inventaire informatique d'entreprise permettant de suivre le matériel et son affectation aux employés.

---

## 📋 Fonctionnalités

### 🛠️ Gestion (CRUD)
- **Matériel** : Enregistrement, suivi de l'état (OK, en panne) et de l'historique (marque, type, date d'achat).
- **Employés** : Gestion complète des utilisateurs par service.
- **Affectations** : Attribution d'équipement à un employé et gestion de la clôture (date de fin).

### 🔍 Filtres avancés
- **Matériel** : Filtrage par type (PC, imprimante...) et par état (OK, en panne).
- **Affectations** : Filtrage par service ou par statut (active, retournée).

### 📊 Statistiques
- Calcul du taux d'utilisation du matériel.
- Analyse du nombre de pannes par catégorie.

---

## ⚙️ Modèle de Données

Le projet repose sur la structure relationnelle suivante :

| Entité | Attributs |
| :--- | :--- |
| **Materiel** | `id`, `ref`, `type`, `marque`, `etat`, `dateAchat` |
| **Employe** | `id`, `nom`, `service`, `email` |
| **Affectation** | `id`, `dateDebut`, `dateFin`, `statut`, `materiel` (@ManyToOne), `employe` (@ManyToOne) |

---

## 🚀 Installation

1. **Cloner le projet** :
   ```bash
   git clone <URL_DU_PROJET>

------------------------------------------------------------------------------------------------------------------------------------------------------------------


<img width="1352" height="697" alt="img-1" src="https://github.com/user-attachments/assets/a8e547a0-b176-45cb-a902-205d4d7c5f6b" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1356" height="708" alt="img-2" src="https://github.com/user-attachments/assets/cfbbaa4c-72a9-459e-a7b7-77b035ec0336" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1352" height="708" alt="img-3" src="https://github.com/user-attachments/assets/24a8c014-75a2-4b35-8d88-aee563564330" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1356" height="717" alt="img-4" src="https://github.com/user-attachments/assets/45ae9b4c-a680-45f6-863f-fd71bbf545a5" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1354" height="703" alt="img-5" src="https://github.com/user-attachments/assets/66fe80bb-49f5-417b-8782-88428bfbd439" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1356" height="703" alt="img-6" src="https://github.com/user-attachments/assets/4d283a41-af61-4221-966b-ba9b3eb244e4" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------

<img width="1356" height="710" alt="img-7" src="https://github.com/user-attachments/assets/cc01463c-1251-4fe6-8f96-9d563467b2bc" />

------------------------------------------------------------------------------------------------------------------------------------------------------------------



