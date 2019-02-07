# spring-data-dynamodb-510-fail-demo

This repository is a demo code to reproduce an error occurred by updating the `spring-data-dynamodb` library.

It is impossible to execute `bootRun` after updating `spring-data-dynamodb` from 5.0.4 to 5.1.0

You can see below exception after executing `bootRun`.

```
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dynamoDB-DynamoDBMapper': Instantiation of bean failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBMapperFactory]: No default constructor found; nested exception is java.lang.NoSuchMethodException: org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBMapperFactory.<init>()
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1270) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1164) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getSingletonFactoryBeanForTypeCheck(AbstractAutowireCapableBeanFactory.java:974) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.getTypeForFactoryBean(AbstractAutowireCapableBeanFactory.java:848) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.isTypeMatch(AbstractBeanFactory.java:574) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doGetBeanNamesForType(DefaultListableBeanFactory.java:514) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeanNamesForType(DefaultListableBeanFactory.java:477) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:598) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.getBeansOfType(DefaultListableBeanFactory.java:590) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBeansOfType(AbstractApplicationContext.java:1204) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.boot.SpringApplication.getExitCodeFromMappedException(SpringApplication.java:905) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.getExitCodeFromException(SpringApplication.java:891) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.handleExitCode(SpringApplication.java:877) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.handleRunFailure(SpringApplication.java:826) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:327) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at kim.myeongjae.springdatadynamodbexample.guestbook.GuestbookApplication.main(GuestbookApplication.java:10) [main/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_191]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_191]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_191]
	at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_191]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49) [spring-boot-devtools-2.1.2.RELEASE.jar:2.1.2.RELEASE]
Caused by: org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBMapperFactory]: No default constructor found; nested exception is java.lang.NoSuchMethodException: org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBMapperFactory.<init>()
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:83) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.instantiateBean(AbstractAutowireCapableBeanFactory.java:1262) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	... 22 common frames omitted
Caused by: java.lang.NoSuchMethodException: org.socialsignin.spring.data.dynamodb.repository.config.DynamoDBMapperFactory.<init>()
	at java.lang.Class.getConstructor0(Class.java:3082) ~[na:1.8.0_191]
	at java.lang.Class.getDeclaredConstructor(Class.java:2178) ~[na:1.8.0_191]
	at org.springframework.beans.factory.support.SimpleInstantiationStrategy.instantiate(SimpleInstantiationStrategy.java:78) ~[spring-beans-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	... 23 common frames omitted
```

After that, change version of versions of libraries in `build.gradle`

from:

```groovy
ext {
	modelMapperVersion = "2.3.0"
	awsJavaSdkDynamoDB = "1.11.490"

//	springDataDynamoDBVersion = "5.0.4"
//	springDataVersion = "2.0.13.RELEASE"
	springDataDynamoDBVersion = "5.1.0"
	springDataVersion = "2.1.2.RELEASE"
}
```

to:

```groovy
ext {
	modelMapperVersion = "2.3.0"
	awsJavaSdkDynamoDB = "1.11.490"

	springDataDynamoDBVersion = "5.0.4"
	springDataVersion = "2.0.13.RELEASE"
//	springDataDynamoDBVersion = "5.1.0"
//	springDataVersion = "2.1.2.RELEASE"
}
```

Then `bootRun` is successfully executed.

The error message have told us that the `DynamoDBMapperFactory` class has no default destructor.

Below is codes of the factory class.

```java
package org.socialsignin.spring.data.dynamodb.repository.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoDBMapperFactory implements FactoryBean<DynamoDBMapper> {

	private final AmazonDynamoDB amazonDynamoDB;
	private final DynamoDBMapperConfig dynamoDBMapperConfig;

	@Autowired
	public DynamoDBMapperFactory(AmazonDynamoDB amazonDynamoDB, DynamoDBMapperConfig dynamoDBMapperConfig) {
		this.amazonDynamoDB = amazonDynamoDB;
		this.dynamoDBMapperConfig = dynamoDBMapperConfig;
	}

	@Override
	public DynamoDBMapper getObject() throws Exception {
		return new DynamoDBMapper(amazonDynamoDB, dynamoDBMapperConfig);
	}

	@Override
	public Class<?> getObjectType() {
		return DynamoDBMapper.class;
	}

}
```