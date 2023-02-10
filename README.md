# Hexagonal Architecture, DDD and Spring

## Overview

이 프로젝트는 DDD를 활용한 스프링 어플리케이션을 만들고 Hexagonal 아키텍처의 도움을 받아 레이어를 구성합니다.

## Hexagonal Architecture

Hexagonal 아키텍처는 도메인 로직 중심의 소프트웨어 어플리케이션 설계 방식 중 하나입니다.
도메인로직은 비즈니스 로직의 중심에 명시됩니다.
도메인 외부에서 내부로 접근하려면 Adapter 또는 Port를 통해야 합니다.

## Prinicples

첫째로 코드를 나누기 위한 원칙을 정의합니다. 앞서 간략하게 설명한 바와 같이 Hexagonal 아키텍처의 내부와 외부를 정의하고 어플리케이션을 세 가지 계층으로 분리합니다.

- Applciation (외부)
- Domain (내부)
- Infrastructure (외부)

![](https://www.baeldung.com/wp-content/uploads/2019/12/DDD-Layers.png)

## Application Layer

Application Layer는 사용자 또는 다른 프로그램의 어플리케이션과 상호 작용합니다.
이 영역은 사용자 인터페이스, RESTful 컨트롤러, JSON 직렬화 로직같은 항목이 포함되어야합니다.
어플리케이션에 대한 엔트리를 노출하고 도메인 로직의 실행을 조정하는 모든 것이 포함됩니다.

## Domain Layer
어플케이션의 핵심 레이어인 Domain Layer에서는 비즈니스 로직을 다루고 구현하는 코드를 만듭니다.
이 계층은 어플리케이션 부분과 인프라 부분 모두로부터 격리되어야 합니다.
여기에 도메인이 상호작용하는 데이터베이스와 같은 외부 부분과 통신할 API를 정의하는 인터페이스도 포함되어야합니다.

## Infrastructer Layer
Infrastructer Layer는 어플리케이션이 작동하는데 필요한 모든 것을 포함하는 부분입니다.
예를 들어 Database configuration, Spring configuration 들이 있습니다.
도메인 계층으로부터 Infrastructure-dependent 한 인터페이스를 구현해야합니다.


## Domain
[Order](/src/main/java/com/orderproductservice/domain/Order.java)는 이 프로젝트의 **에그리거트 루트**입니다.
- 모든 비즈니스 로직은 Order Class를 통해서 진행되고 Order Class는 **정확한 Status를 유지할 책임**이 생깁니다.
- Order는 지정된 ID로만 생성할 수 있으며 하나의 Product를 기반으로 생성됩니다.
- Order Class 외부에서 Order를 변경할 수 없습니다. (Setter 함수)
- Order Class는 **OrderItem을 생성할 책임**도 생깁니다.





[Baeldung](#https://www.baeldung.com/hexagonal-architecture-ddd-spring)