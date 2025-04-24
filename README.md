# 🏛️ Museum Finder

O **Museum Finder** é uma API REST desenvolvida em Java com Spring Boot que permite o cadastro e a consulta de museus, incluindo funcionalidades de geolocalização e contagem por tipo de coleção. A aplicação simula um banco de dados e trabalha com dados reais carregados via JSON.

---

## 🚀 Tecnologias e Ferramentas Utilizadas

- **Java 17** — linguagem principal, com recursos modernos de POO e Streams.
- **Spring Boot 3** — framework web que estrutura a aplicação de forma robusta.
  - **Spring Web** — construção dos endpoints REST.
  - **@RestController**, **@Service**, **@Component**, **@ControllerAdvice** — separação clara das responsabilidades e aplicação de boas práticas do Spring.
- **Jackson (ObjectMapper)** — serialização e desserialização de dados JSON.
- **Maven** — gerenciamento de dependências e build da aplicação.
- **Java Streams e Lambdas** — processamento eficiente de listas e filtros.
- **Banco de dados fake** com simulação de persistência usando `MuseumFakeDatabase`.
- **DTOs (Data Transfer Objects)** — abstração entre modelo e dados expostos via API.
- **Tratamento global de exceções** — para erros personalizados e respostas consistentes.
- **Arquitetura em camadas e princípios SOLID** — código limpo, modular e testável.

---

## 📦 Funcionalidades

- 📍 Buscar o museu mais próximo com base em coordenadas (latitude, longitude e raio).
- 🏛️ Cadastrar novos museus com validação de coordenadas geográficas.
- 📊 Contar a quantidade de museus por tipo(s) de coleção.
- ⚠️ Retorno de mensagens de erro claras em casos de coordenadas inválidas ou museus não encontrados.

---

## 📁 Estrutura do Projeto

```plaintext
com.betrybe.museumfinder
├── advice/                  # Tratamento global de exceções
│   └── GeneralControllerAdvice.java
├── controller/              # Endpoints da API
│   ├── MuseumController.java
│   └── CollectionTypeController.java
├── service/                 # Regras de negócio
│   ├── MusemService.java
│   ├── MuseumServiceInterface.java
│   └── CollectionTypeService.java
├── model/                   # Modelos de domínio
│   ├── Museum.java
│   └── Coordinate.java
├── database/                # Simulação de repositório
│   └── MuseumFakeDatabase.java
├── dto/                     # Transferência de dados (Request/Response)
│   ├── MuseumCreationDto.java
│   ├── MuseumDto.java
│   └── CollectionTypeCount.java
├── exception/               # Exceções customizadas
│   ├── MuseumNotFoundException.java
│   └── InvalidCoordinateException.java
├── util/                    # Classes auxiliares
│   ├── CoordinateUtil.java
│   ├── ModelDtoConverter.java
│   └── MuseumLoader.java
└── MuseumFinderApplication.java   # Classe principal (entrypoint)
```
## 🧪 Como Rodar o Projeto Localmente

1. Certifique-se de ter **Java 17** e **Maven** instalados.
2. Clone o repositório:

```bash
git clone https://github.com/seuusuario/museum-finder
cd museum-finder
```

3. Execute o projeto:

```bash
mvn spring-boot:run
```

4. A aplicação estará disponível em:  
`http://localhost:8080`

---

## 🐳 Como Rodar o Projeto com Docker

Se preferir rodar o projeto em um container Docker, siga os passos abaixo:

1. **Certifique-se de que o Docker está instalado** em sua máquina.

2. **Clone o repositório**:

   ```bash
   git clone https://github.com/seuusuario/museum-finder
   cd museum-finder
   ```

3. **Construir a imagem Docker**:

   Na raiz do projeto (onde o `Dockerfile` está localizado), execute o seguinte comando:

   ```bash
   docker build -t museum-finder .
   ```

   Esse comando criará a imagem Docker com o nome `museum-finder`.

4. **Rodar o container Docker**:

   Após a construção da imagem, execute o container com o seguinte comando:

   ```bash
   docker run -p 8080:8080 museum-finder
   ```

   Isso fará com que a aplicação seja executada no Docker e estará disponível em `http://localhost:8080`.

---
## 📫 Endpoints da API

| Método | Rota                                                  | Descrição                                                  |
|--------|-------------------------------------------------------|------------------------------------------------------------|
| POST   | `/museums`                                            | Cria um novo museu.                                        |
| GET    | `/museums/closest?lat=...&lng=...&max_dist_km=...`    | Retorna o museu mais próximo baseado em coordenadas.       |
| GET    | `/collections/count/{typesList}`                      | Retorna o número de museus por tipo de coleção.            |

---

