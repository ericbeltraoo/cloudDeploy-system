# CloudDeploy System - Simulador de Alocação de Infraestrutura ☁️

O **CloudDeploy** é um sistema de suporte à decisão para operações de TI e Engenharia de Software. Ele automatiza a validação de *deploys* de aplicativos em servidores, garantindo que os requisitos técnicos sejam atendidos sem comprometer a viabilidade financeira e o orçamento departamental.

## 🚀 Funcionalidades

*   **Simulação Multi-Servidor:** Permite testar o mesmo aplicativo em diferentes infraestruturas simultaneamente para identificar o melhor host.
*   **Análise de Viabilidade Técnica:** Valida se há Memória RAM e Armazenamento disponíveis para os requisitos do microsserviço.
*   **Gestão de Custos Operacionais:** Calcula o custo de alocação baseado em hardware (RAM/SSD) com taxas de segurança integradas.
*   **Governança Financeira:** Bloqueia deploys que excedam o orçamento do departamento ou que possuam uma margem de lucro insuficiente.

## 🛠️ Conceitos de Engenharia Aplicados

Este projeto foi estruturado utilizando as melhores práticas de **Programação Orientada a Objetos (POO)**:

*   **Membros Estáticos:** Centralização de regras de negócio e constantes em uma classe utilitária de cálculos (Calculos.java).
*   **Separação de Responsabilidades:** Divisão clara entre classes de aplicação, entidades de dados e lógica de processamento.
*   **Tratamento de I/O:** Gerenciamento de entrada de dados via console com tratamento de buffer e formatação de localização (Locale US).

## 📂 Estrutura do Repositório

*   **entities**: Contém os modelos de dados para \Aplicativo\, \Departamento\ e \Infraestrutura\.
*   **util**: Classe \Calculos\ que centraliza as fórmulas de precificação de nuvem.
*   **pplication**: Ponto de entrada do sistema que coordena as simulações e exibe os vereditos.

## 📊 Regras de Negócio Implementadas

1.  **Custo RAM:** R$ 28,50 / GB.
2.  **Custo Armazenamento:** R$ 2,15 / GB.
3.  **Taxa de Segurança:** 8% sobre o custo base de alocação.
4.  **Limite Comercial:** O custo de infraestrutura deve ser ≤ 15% da receita prevista do app.

## 💻 Como Executar

1. Clone este repositório:
   \\\ash
   git clone https://github.com/ericbeltraoo/cloud-deploy-java.git
   \\\
2. Certifique-se de ter o **JDK 17** (ou superior) instalado.
3. Execute a classe \Main\ no pacote \pplication\.

---
Desenvolvido por **Eric Beltrão Valente**
*Focado em desenvolvimento Back-end com Java e Spring Boot.*
