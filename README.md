# API Joga10 NoSQL

API desenvolvida em Spring Boot com MongoDB para integração do aplicativo Joga10, focada em gestão esportiva, reservas de quadras, partidas, avaliações de jogadores, amizades, estabelecimentos e meios de pagamento.

## Funcionalidades
- Cadastro e gerenciamento de jogadores (Players)
- Cadastro e gerenciamento de times (Teams)
- Criação e gerenciamento de partidas (Matches)
- Avaliação de jogadores (Player Ratings)
- Cadastro de quadras (Courts) e reservas de quadras (Court Reservations)
- Cadastro de estabelecimentos com geolocalização (Establishments)
- Listagem de quadras por estabelecimento
- Cadastro e gerenciamento de amizades (Friendships)
- Cadastro de meios de pagamento (PIX, cartão de crédito)

## Endpoints principais
- `/api/players` — Jogadores
- `/api/teams` — Times
- `/api/matches` — Partidas
- `/api/player-ratings` — Avaliações de jogadores
- `/api/courts` — Quadras
- `/api/courts/establishment/{establishmentId}` — Quadras de um estabelecimento
- `/api/court-reservations` — Reservas de quadras
- `/api/establishments` — Estabelecimentos
- `/api/establishments/with-courts` — Estabelecimentos com suas quadras
- `/api/establishments/{id}/courts` — Quadras de um estabelecimento específico
- `/api/friendships` — Amizades
- `/api/payment-methods` — Meios de pagamento

## Como rodar
1. Configure o MongoDB local ou remoto e ajuste a string de conexão em `src/main/resources/application.properties`.
2. Compile e execute o projeto:
   ```sh
   ./mvnw spring-boot:run
   ```
3. Acesse os endpoints via Postman, Insomnia ou pelo app Joga10.

## Sobre
Este projeto é parte do ecossistema Joga10, focado em facilitar a gestão esportiva e integração de dados do app com banco NoSQL.

---

Desenvolvido por Leonardo Noronha de Andrade
