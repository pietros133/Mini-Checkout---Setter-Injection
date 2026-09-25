# Mini Checkout — Setter Injection

Projeto desenvolvido para praticar **Programação Orientada a Objetos (POO)** e, principalmente, o conceito de **Setter Injection**, utilizado posteriormente em frameworks como o **Spring Framework**.

A ideia é simular um pequeno sistema de checkout que permite escolher diferentes formas de pagamento e realizar o processamento do valor.

## Objetivo

Este projeto foi criado como exercício prático para entender como trabalhar com:

* Interfaces
* Implementação de interfaces
* Polimorfismo
* Injeção de dependência
* Setter Injection
* Separação de responsabilidades
* Regras de negócio
* Estruturas condicionais
* Entrada de dados com `Scanner`

O objetivo principal não é criar um checkout completo, mas entender **como uma classe pode receber uma dependência externamente**, em vez de criá-la diretamente dentro dela.

---

## Conceito principal

O projeto possui uma interface de pagamento:

```java
public interface Payment {
    void pay(double amount);
}
```

Cada forma de pagamento implementa essa interface:

```text
Payment
   │
   ├── PixPayment
   ├── CardPayment
   └── BoletoPayment
```

O `CheckoutService` recebe a implementação através de um **setter**:

```java
public void setPayment(Payment payment) {
    this.payment = payment;
}
```

Dessa forma, o `CheckoutService` não precisa saber qual implementação específica será utilizada.

Por exemplo:

```java
checkout.setPayment(new PixPayment());
```

ou:

```java
checkout.setPayment(new CardPayment());
```

A dependência pode ser trocada durante a execução do programa.

---

## Regra de negócio

O projeto também possui uma regra adicional de cobrança:

* PIX → sem taxa adicional
* Cartão → se o valor for maior que `$200`, é adicionada uma taxa de **15%**
* Boleto → se o valor for maior que `$200`, é adicionada uma taxa de **15%**

### Exemplo

Valor:

```text
$300
```

Pagamento via cartão:

```text
$300 + 15%
= $345
```

Pagamento via PIX:

```text
$300
```

---

## Funcionamento

Ao executar o programa, o usuário encontra um menu:

```text
=== MINI CHECKOUT ===
1. PIX
2. Credit Card
3. Bank Slip
0. Exit
Choose an option:
```

Depois de escolher uma forma de pagamento válida, o sistema solicita o valor:

```text
Enter the amount: $300
```

O checkout então processa o pagamento utilizando a implementação escolhida.

Caso uma opção inválida seja informada:

```text
Invalid option!
```

O sistema retorna diretamente para o menu sem solicitar o valor.

---

## Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── org/
            └── example/
                ├── Main.java
                ├── CheckoutService.java
                │
                └── paymentTypes/
                    ├── PixPayment.java
                    ├── CardPayment.java
                    └── BoletoPayment.java
```

---

## O que estou praticando

Este projeto faz parte dos meus estudos de **Java e Spring Framework**.

A intenção é entender os conceitos primeiro utilizando **Java puro**, antes de deixar o Spring fazer esse trabalho automaticamente através do seu container de dependências.

### Java puro

```java
checkout.setPayment(new PixPayment());
```

### Conceito que futuramente será utilizado no Spring

```java
@Autowired
private Payment payment;
```

A ideia é entender primeiro **o que está acontecendo por baixo dos panos**, antes de utilizar as abstrações do framework.

---

## Tecnologias

* Java
* POO
* Interfaces
* Polimorfismo
* Setter Injection
* IntelliJ IDEA / IDE compatível
* Git & GitHub

---

## Aprendizado

O principal aprendizado deste projeto é entender que **injeção de dependência não é algo exclusivo do Spring**.

O Spring apenas automatiza e gerencia esse processo através do seu container de IoC.

Neste projeto, a dependência é fornecida manualmente:

```java
checkout.setPayment(new PixPayment());
```

Isso ajuda a visualizar o conceito antes de avançar para recursos como:

* `@Component`
* `@Service`
* `@Autowired`
* `@Bean`
* IoC Container
* Constructor Injection
* Setter Injection

---

## Autor

**Pietro Santos Miranda**
