# FireWatch - Monitoramento Espacial de Queimadas

## 1. Descrição da Solução
O **FireWatch** é uma solução mobile desenvolvida para o contexto da economia e monitoramento espacial. O aplicativo utiliza dados abertos provenientes de satélites do **INPE (Instituto Nacional de Pesquisas Espaciais)** para fornecer, em tempo real, o monitoramento de focos de incêndio no território brasileiro. O objetivo é auxiliar produtores rurais e equipes de segurança no monitoramento ambiental e na prevenção de desastres, calculando a distância e o risco de propagação de focos de calor em relação a uma propriedade específica.

## 2. Tecnologias Utilizadas
* **Linguagem:** Kotlin
* **Framework:** Jetpack Compose (UI Declarativa)
* **Arquitetura:** MVVM (Model-View-ViewModel) para separação de responsabilidades.
* **Mapas:** Google Maps SDK for Android.
* **Comunicação:** Consumo de APIs de dados abertos (CSV diário do INPE).
* **Navegação:** Navigation Compose.

## 3. Estrutura do Projeto (MVVM)
O projeto foi organizado para garantir escalabilidade e boas práticas de desenvolvimento:
* **`data.model`**: Define as entidades de dados (`FireFocus`, `Severidade`).
* **`data.service`**: Camada responsável pela comunicação com o INPE e processamento de dados.
* **`ui.screen`**: Telas de interface do usuário (`LoginScreen`, `MonitoringScreen`, etc).
* **`ui.theme`**: Definições de design, cores e tipografia.
* **`viewModel`**: Camada de lógica que gerencia o estado da aplicação entre a UI e os dados.

## 4. Funcionalidades Principais
* **Autenticação:** Tela de Login e Cadastro (Simulada).
* **Geolocalização Dinâmica:** O usuário pode definir sua propriedade via latitude/longitude ou interação direta (clique longo) no mapa.
* **Monitoramento Real-time:** Mapeamento de focos de incêndio reais via satélite.
* **Análise Preditiva:** Cálculo automático de distância via fórmula de *Haversine* com classificação de risco (Baixo, Médio, Alto, Crítico).
* **Chamada de Emergência:** Botão rápido para contato com os Bombeiros (193).

## 5. Fluxo de Navegação
1. **Login:** Acesso inicial do usuário.
2. **Dashboard (Monitoring):** Visualização do mapa interativo com os focos detectados.
3. **Perfil:** Visualização de informações do usuário.

---
*Projeto desenvolvido para a Global Solution - Indústria Espacial.*