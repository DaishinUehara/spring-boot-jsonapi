# Spring Boot JsonAPI Sample

- Spring BootでJSONを返すサンプルです。
- JPAでH2にアクセスする構成となっています。
- ビルドにはmavenを用いており、リソースファイルはPJの外部ファイルの設定により書き換わります。

## 準備

- 事前にmavenをインストールしておいてください。
- ~/.m2/settings.xmlにたとえば以下のような内容でファイルを作成しておいてください

``` xml
  <settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <profiles>
      <profile>
        <id>develop</id>
        <activation>
          <activeByDefault>true</activeByDefault>
        </activation>
        <properties>
          <spring.datasource.driver>org.h2.Driver</spring.datasource.driver>
          <spring.datasource.url>jdbc:h2:./h2db/[開発環境DBファイル名]</spring.datasource.url>
          <spring.datasource.username>[開発環境DBユーザ名]</spring.datasource.username>
          <spring.datasource.password>[開発環境DBパスワード]</spring.datasource.password>
          <spring.h2.console.enabled>true</spring.h2.console.enabled>
          <spring.h2.console.path>/h2-console</spring.h2.console.path>
          <spring.h2.console.settings.web-allow-others>true</spring.h2.console.settings.web-allow-others>
          <test.spring.datasource.driver>org.h2.Driver</test.spring.datasource.driver>
          <test.spring.datasource.url>jdbc:h2:./h2db/[開発環境UnitテストDBファイル名]</test.spring.datasource.url>
          <test.spring.datasource.username>[開発環境UnitテストDBユーザ名]</test.spring.datasource.username>
          <test.spring.datasource.password>[開発環境UnitテストDBパスワード]</test.spring.datasource.password>
          <test.spring.h2.console.enabled>true</test.spring.h2.console.enabled>
          <test.spring.h2.console.path>/h2-console</test.spring.h2.console.path>
          <test.spring.h2.console.settings.web-allow-others>true</test.spring.h2.console.settings.web-allow-others>
        </properties>
      </profile>
      <profile>
        <id>production</id>
        <properties>
          <spring.datasource.driver>org.h2.Driver</spring.datasource.driver>
          <spring.datasource.url>jdbc:h2:./h2db/[本番環境DBファイル名]</spring.datasource.url>
          <spring.datasource.username>[本番環境DBユーザ名]</spring.datasource.username>
          <spring.datasource.password>[本番環境DBパスワード]</spring.datasource.password>
          <spring.h2.console.enabled>true</spring.h2.console.enabled>
          <spring.h2.console.path>/h2-console</spring.h2.console.path>
          <spring.h2.console.settings.web-allow-others>false</spring.h2.console.settings.web-allow-others>
          <test.spring.datasource.driver>org.h2.Driver</test.spring.datasource.driver>
          <test.spring.datasource.url>jdbc:h2:./h2db/[本番環境UnitテストDBファイル名]</test.spring.datasource.url>
          <test.spring.datasource.username>[本番環境UnitテストDBユーザ名]</test.spring.datasource.username>
          <test.spring.datasource.password>[本番環境UnitテストDBパスワード]</test.spring.datasource.password>
          <test.spring.h2.console.enabled>true</test.spring.h2.console.enabled>
          <test.spring.h2.console.path>/h2-console</test.spring.h2.console.path>
          <test.spring.h2.console.settings.web-allow-others>false</test.spring.h2.console.settings.web-allow-others>
        </properties>
      </profile>
    </profiles>
  </settings>
```
## リソースファイルの生成

以下でtarget/classes以下にリソースファイルが作成される。

``` text
  $ mvn resources:resources
```


## テスト

以下でテストが行われます。

``` text
  $ mvn test
```

## パッケージ作成

以下でパッケージが作成されます。

``` text
  $ mvn package
```

パッケージはtarget直下にjar形式で作成されます。
以下で起動

``` text
  $ java -jar spring-boot-jsonapi-1.0.0-SNAPSHOT.jar
```

本番用のパッケージを作成する場合には一度cleanした後。
``` text
  $ mvn -Pproduction package
```

``` test
  http://localhost:8080/display/getall
```

などとすることでデータをみる事が可能です。

## インストール

通常は以下で~/.m2リポジトリにインストールすることができます。

``` text
  $ mvn install
```

しかしプロセスが起動したままだと、リネームに失敗することがあります。
その場合には全てのプロセスを削除した上で、以下のようにしてください。

``` text
  $ mvn clean package spring-boot:repackage
```


