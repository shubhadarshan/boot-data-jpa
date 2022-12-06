# boot-data-jpa

**exploring concepts of spring boot data-jpa module**

### JPA annotations

### CRUD Operations

### Primary Key Generators

### Composite Primary Key

### Composite Primary Key with the help of a Sequence

### Custom Primary Key

### In memeory databases

<ol>
  <li>H2 Database</li>
</ol>


## References 
What is Persistence Store?
Persistence means storage. The place where we will save our data is called as Persistent Store.

#### Persistent Operations
1. Inserting data
2. Updating data
3. Deleting data
4. Retrieve data

#### Persistent Technologies
Persistent technologies are used to develop persistent logic. 
Persistent logic is used to perform persistent operations in persistent store. 

We have several technologies to develop persistent logic
1. Java JDBC
2. Spring JDBC
3. ORM Framworks
4. Spring Data 
etc...

Best Practices to develop persistent logic

1. We should maintain persistent logic as separate layer (Dao layer or repository layer)
2. Generally we will call it as "Data Access Layer" (DAO)
3. In persistent logic we should follow Table per Dao concept.
4. For every table dedicated Dao we need to create. That dao only responsible to perform
   operations with that table. (Which improves readability) (single responsibility principal)

USER_MASTER -> UsermasterDao.java
               UsermasterDaoImpl.java
ROL_EMASTER -> RolemasterDao.java
               RolemasterDaoImpl.java
CO_TRIGGERS -> CoTriggersDao.java 
               CoTriggersDaoImpl.java 
               CoTriggersDaoExtenderImpl.java 
ACCNT_DTLS -> AccntDt1sDao.java


#### Table creation recommendation 
When we are creating table names, column names, sequence names the length limitation is 30 characters.
If required name is having more than 30 characters generally people will ignore vowels (a, e, i, o & u) from the name.
USER_MASTER -> USR_MSTR
CREDIT_CARD_NUMBER -> CRDT_CRD_NMBR

For every table at least one primary key is highly recommended. 

For every it is highly recommended to main below auditing columns - 
1. CREATED_DATE
2. CREATED_BY
3. UPDATED_DATE
4. UPDATED_BY

For Every Primary key create dedicated sequence to generate primary key column value. 
Always recommended to maintain cache for static table data to avoid DB interactions. 


#### Environment Setup
Persistence logic will communicate with persistent store (File System & Database). 
We will use Database as Persistent Store in our applications development. 

Database Installation
1. Database Server (remote machine)
2. Database Client (connect to server with ip,url,username,password)

In company environment, DB server will be installed by DB admins in Remote machines. After installing DB server, DB team will share Database details to team members [URL, Uname, PWD , Service Name]. 

Developers & Testers will install Database Client Software in their machines Ex : SQL Developer, Toad etc.

For Learning/Training purpose, in my machine i'll install both DB server and DBclient softwares. 
   DB server : OracleXE.exe
   DB Client : SQL Developer (Open Source)

#### Persistent Technologies in Java
There are several options are available to develop Persistent logic in java applications
1. Java JDBC
2. Spring JDBC
3. ORM frameworks
4. spring ORM
5. Spring Data

*ORM* is a programming technic that we can use to directly map the application model object to the database table.  

**JPA** 
Jakarta Persistence (JPA), formerly known as **Java Persistence API**.
JPA is just a specification that facilitates object-relational mapping to manage relational data in Java applications.
It provides a platform to work directly with objects instead of using SQL statements.
JPA implementation Hibernate, MyEclipseLink, Mybatis. 

**Hibernate ORM framework** 
Hibernate is a java based ORM tool that provides a framework for mapping application domain objects to the relational database tables and vice Versa.
Hibernate provides JPA implementation that maps your database records to Java objects and generates the required SQL statements to replicate all operations to the database.

#### Generic Persistent Operations
1. Insert one record
2. insert multiple records at a time
3. update record
4. update multiple records at a time
5. retrieve one record
6. retrieve all records
7. retrieve few record
8. delete one record
9. delete few records at a time
10. delete all records
11. get count records

To perform above operations we need to write methods in DAO interface & we should implement those methods in DaoImpl class.
If our project contains 100 tables then we will create 100 Dao interfaces. In all Dao interfaces above methods will be common.
We need to implement all Dao interfaces ( We need to implement all those methods)
***All the implementation classes will contains same logic (Boiler plate code).***

***Spring Data***
To avoid boiler plate code in Dao layer *Spring Data* came into picture. If we use Spring Data then we no need to write even single method also method to perform above curd operations for tables. Spring Data providing predefined methods for use to perform curd operations.

#### DAO(Data Access Object) design pattern
1. Data Access Object or DAO design pattern is a popular design pattern to implement persistence layer of Java application.
2. The DAO pattern is a structural pattern that allows us to isolate the application/business layer from the
persistence layer using an abstract API.
3. In short DAO design pattern is a way to reduce coupling between Business logic and Persistence logic.
4. We can develop Dao layer using JDBC API, Hibernate(ORM fw),Spring jdbc etc. 

**Advantages of dao**
1. While changing a persistence mechanism, service layer doesn't even have to know where the data comes from.
   For example, if you're thinking of shifting from using MySQL to MongoDB, all changes are needed to be done in the DAO layer only.
2. DAO pattern emphasis on the low coupling between different components of an application. 
   So, the View layer have no dependency on DAO layer and only Service layer depends on it, even that with the interfaces and not from concrete implementation.
3. As the persistence logic is completely separate, it is much easier to write Unit test cases for individual components.
   For example, if you're using JUnit & Mockito for testing frameworks, it will be easy to mock the individual components of your application.
4. As we work with interfaces in DAO pattern, it also emphasizes the style of *work with interfaces instead of implementation* which is an excellent OOPs style of programming.

#### Best Practices to Develop Persistence or DAO Layer
1. Separate Layer for Persistence logic or database related code (We should maintain persistent logic as separate layer ( DAO Layer or Persistence Layer))
2. In persistence logic, we should follow table per DAO class pattern. 
   For every table, we will create a dedicated DAO class and this DAO class is responsible to perform operations with That table (which improves readability). 
   USER --> UserDao.java
   CUSTOMER --> Customer-Dao. java
   ROLES --> RolesDao.java
   ACCOUNT_DETAILS --> AccountDetailsDao.java

   USER -> UserDao.java
           UserDaoImpl. java
   CUSTOMER -> CustomerDao.java
               CustomerDaoImp1. java
   ROLES -> RolesDao.java
            RolesDaoImpI. java

3. At least one primary key per table.
4. Auditing columns
   - CREATED DATE
   - CREATED BY
   - UPDATED DATE
   - UPDATE BY


#### spring-data 
Spring Data JPA is not a JPA provider. It simply "hides" the Java Persistence API (and the JPA provider) behind its repository abstraction. Spring Data JPA uses Hibernate as a default JPA provider.

#### Basic flow of spring-data-jpa 
service
    -> JpaRepository(I) 
            Impl class will be generated at runtime (runtime proxy)
            Handler classes are  
               1. SimpleJpaRepository 
               2. CustomRepositoryImpl (custom we can provide implementation)
    -> Spring data jpa internally uses JPA API (hibernate as JPA provider) 
    -> Hibernate core api will be called 
    -> Hibernate will use Jdbc 
    -> Jdbc will use native api to communicate with database  

#### Spring-data-jpa vs jpa vs hibernate vs jdbc 
**Spring Data JPA** is an abstraction layer on top of JPA to Reduce the amount of boilerplate code required to implement data access object (DAO) layer. It is not a JPA provider. It simply "hides" the Java Persistence API (and the JPA provider) behind its
repository abstraction.
Spring Data JPA uses Hibernate as a default JPA provider.
Spring Data JPA cannot work without a JPA provider.

**JPA** is just a specification that facilitates object-relational mapping to manage relational data in Java applications.
**Hibernate** is a java based ORM tool that provides a framework for mapping application domain objects to the relational database tables and vice versa. Hibernate is a JPA provider ( JPA specification implementation). Hibernate uses jdbc to interact with database.  

**Jdbc** is a low level database api. Every framework works with Jdbc in order to communicate with database. 

#### spring-data-jpa core classes 
Spring Data Provided 2 predefined repository interfaces they are
1. CrudRepository
2. JpaRepository

These two interfaces provided several methods to perform curd operations. To use Spring Data Repository interfaces provided method we should create our own repository interface by extending Spring Data Repository interface.
- public interface UserMasterRepo extends CurdRepository<E,ID<{}
- public interface UserMasterRepo extends JpaRepository<E,ID>{}

What is the difference between CrudRepository and JpaRepository?
1. CurdRepository provided methods to perform curd operations
2. JpaRepository provided methods to perform curd operations + pagination + sorting
***We can say JpaRepository is superior to CurdRepository***

### Steps to develop SpringBoot application using Spring Data JPA
**Make sure Database server is installed in machine**

Create Spring Boot standalone application with below dependencies
1. spring-boot-starter
2. spring-boot-starter-data-jpa
3. Database Driver (Oracle Driver)
4. Project Lombok

Configure DataSource properties in application. properties file
Create Entity class (Java class -> db table mapping)
Create repository interface for our entity by extending Spring Data repository
Test application behavior. 

**database :**
create table contacts_master
(
    contact_id  int not null primary key,
    contact_name  varchar(45) null,
    contact_number int null
);

#### spring-boot-starter-data-jpa breakdown
This is starter dependency. It maintain all required dependency for out dao layer development. If we don't use the starter dependency we have to maintain all its interim dependencies & it's compatible version.     

***connecting to database from spring-boot***
</u>application.properties</u>
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true

### Jpa Annotations 
@Entity - javax.persistence.Entity
        - To specify a class a JPA entity.
        - we need to use it as a Class level. 

@Id - javax.persistence.Entity
    - field level 
    - specify this field is mapped as a Primary key Id 

@Table(name = "products", schema = "ecommerce") - javax.persistence.Entity 
   - to customize table name (from entity class name)
   - schema - in which schema/database we are creating the Table 

@Table(
        name = "products",
        schema = "ecommerce",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique",columnNames = "sku"),
                @UniqueConstraint(name = "url_unique", columnNames = "imageUrl" ) 
        }
)

uniqueConstraints - javax.persistence.UniqueConstraint 
   - to make a field as unique column in the database

@Column(name = "stock_keeping_unit", nullable = false) 
   - to customize the column name 

@Column(nullable = false)
   - to make a column as non-nullable 

**Timestamp annotations (hibernate provided)**
org.hibernate.annotations.*;
@CreationTimestamp
private LocalDateTime dateCreated;
@UpdateTimestamp
private LocalDateTime lastUpdated;

@Embeddeable 
This class is embeddeable on an another class. 

@Embedded
This property is a embedded property. 

@EmbeddedId 
We used for embedding primary key.

@IdClass(EmployeePKID.class) 
Use this class property as id's . 

### Id Generators
When we are working Database tables, it is highly recommended to maintain primary key column in tables.
Using Primary Key columns we can maintain unique data in tables. 
When we are working with ORM frameworks Primary Key column is mandatory in tables.
If table doesn't contain primary key column then ORM frameworks can't perform operations with that table.
When we are creating Entity class we will use **@ld** annotation. It represents this variable mapped with Primary Key column in table. 
```java
@Entity 
@Table 
public class ProductEntity{
   @Id
   @column(name = "PID")
   private Integer productid;
   @column(name = "PNAME")
   private String productName;
   @column(name = "PRICE")
   private String productPrice;
}
```

**A DB table can contain more than one Primary Key Column also. If a table contains more than one primary key column then it is called as Composite Primary Key.**

Primary key is a constraint in database and it is combination of below 2 constraints
1. UNIQUE
2. NOT NULL
**That mean PK column value should not be duplicate and it should not be null.**

If we ask end user to enter value for Primary Key column he may enter duplicate value or they may enter random number for primary key column value.
To avoid these problems, instead of asking end users to enter the value it is highly recommended to generate the value for Primary Key column in our code.
To generate value for Primary Key column **Generators** came into picture.

In **ORM framework Hibernate** we have 11 predefined generators. Every Generator will follow it's own algorithm to generate value for Primary Key column. If we don't like predefined generator algorithm, we can create user-defined (custom) generator to generate value for Primary Key column. 
***Every Generator implements IdentifierGenerator(I) available in hibernate.***

**hibernate generators**
1. assigned
2. increment
3. sequence
4. hilo
5. native
6. identity
7. seqhilo
8. uuid
9. guid
10. select
11. foreign
12. sequence-identity

#### Working with generator in data-jpa 
##### Primary key GENERATORS strategy  

javax.persistence.*; 

@Id
@GeneratedValue(strategy=GenerationType.Identity)
private long id;

key generation strategy
1. GenerationType.AUTO - default generation type 
2. GenerationType.Identity
3. GenerationType.SEQUENCE 
4. GenerationType.TABLE 


##### 1. GenerationType.AUTO 
```java
@Id
@GeneratedValue //default generation type 
   (or)
@GeneratedValue(strategy=GenerationType.AUTO)
private Integer cid;
```

With the above configuration in entity, it is using Hibernate default sequence to generate value for PK column.
**Default Sequence Name - HIBERNATE_SEQUENCE**

In hibernate framework, **hibernate_sequence** is default sequence. If auto ddl is enabled then only hibernate_sequence will be created with the behavior start with 1 increment by 1.

If we use this default sequence for more than one primary key columns then order of primary key value will be disturbed.
To avoid this problem we will create dedicated sequence for every primary colum. 

##### Working with sequence 
**Creating Sequence**
   create sequence <sequence-name> start with 1 increment by 1

**Reading Current Value From sequence**
   select sequence-name.currval from dual

**Reading Next Value From sequence**
   select sequence-name.nextval from dual

**dropping the sequence**
   drop sequence-name

**Sequences are db dependent. Oracle will support where MySql will not support for sequences. In realtime for every primary key column Dedicated Sequence will created**


**In Mysql database** 
As we know MySQL doesn't support sequence, In case of MySQL database, Hibernate will create a separate table to maintain sequences as a primary keys. 
   
create table hibernate-sequence (
   next-vat bigint
) 

##### 2. GenerationType.Identity
```java 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY) //auto-incremented database column
@Column(name = "id")
private Long ld;
```
- It relies on an auto-incremented database column & lets the database generate a new value with each insert operation.
- From a database point of view, this is very efficient because the auto-increment columns are highly optimized, and it doesn't require any additional statements.
- Not good for JDBC batch operations

##### 3. GenerationType.SEQUENCE 
```java
@Id
@GeneratedValue ( strategy = GenerationType.SEQUENCE,
                  generator "product-generator")
@SequenceGenerator( name = "product _ generator",
                   sequenceName = "product_sequence_name",
                   allocationSize = 1)
private Long id;
```
The GenerationType.SEQUENCE is to generate primary key values and uses a database sequence to generate unique values. It requires additional select statements to get the next value from a database sequence. But this has no performance impact on most applications.
The **@SequenceGenerator** annotation lets you define the name of the generator, the name, and schema of the database sequence and the allocation size of the sequence.

4. GenerationType.TABLE 
=======================
@Id
@GeneratedValue(strategy = GenerationType.TABLE)
@Column(name = "id")
private Long ld;

** rarely used these days 

Working with custom sequences 
=============================
1. Create Sequence in database
   create sequence <sequence-name> start with 1 increment by 1;
2. Configure created sequence in Entity class 
      @Id
      @SequenceGenerator(name = "alias-name", sequenceName= "seq_name",allocationSize=1)
      @GeneratedValue(generator="a1ias-name", strategy=GenerationType.SEQUENCE)
      private Integer cid;

Working with Custom Generator
============================
According to client requirement sometime we need to go for Custom generators. 

Use case
---------
   Emp ids -> TCSI, TCS2, TCS3 
   Online Order Ids -> ODI, OD2, OD3

To create Custom Generator we should implement IdentifierGenerator interface. 
In that interface we have generate() method, write logic in that method to generate PK column value according to our requirement.

If we want to store value in this format our PK column type should be VARCHAR. 
The order id can be divided into 2 parts
   a)prefix -> It is fixed value
   b)suffix -> Number(start with I increment by 1)
As prefix is fixed we can create a constant for that & for Suffix value we can create a Sequence. 

Steps to develop Data JPA application with Custom Generator
-----------------------------------------------------------
1. Create Spring Starter project with below dependencies
      a) spring-boot-starter-data-jpa
      b) oracle driver
      c) project lombok

2. Create Entity class using Annotations.
3. Create Sequence in DB for suffix value generation.
4. Create Custom Generator class by implementing `IdentifierGenerator` interface.
5. Configure Custom Generator in Entity
6. Create Repository interface by extending data jpa repository

@Id
@Column(name = "order_id")
@GenericGenerator(
        name = "cust_gen",
        strategy = "impl class FQCN")
@GeneratedValue(generator = "cust_gen")
public class OrderIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return null;
    }
}

Composite Primary Key 
====================
Let's say that We have an application that manages Employees of various companies.
Every employee has a unique employeeId within his company.
But the same employeeId can be present in other companies as well, So we can not uniquely identity an employee just by his employeeId.

Table - 
         employees
            company_id VARCHAR(255)  (PK)
            employee_id VARCHAR(255) (PK)
            email VARCHAR(100)
            name VARCHAR(255)
            phone_number VARCHAR(15)


sequence-based composite primary
===============================
@IdClass(ChessPlayerId.class)

@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_seq")
@SequenceGenerator(name = "player_seq", sequenceName = "player_seq", initialValue = 100)
private Long id;

@Id
private String country;

Repository Interfaces & it’s hierarchy
======================================
spring-data-commons (parent project holds the common persistence functionality)
Spring Data LDAP
Spring Data MongoDB
Spring Data JPA (support for JPA-based data access layers)
Spring Data JDBC

All these are separate project to develop dao layer & spring-data-commons is their parent project.

Repository
==========
Repository<T, ID extends Serializable>

CrudRepository<T, ID extends Serializable> extends Repository

PagingAndSortingRepository«T, ID extends Serializable> extends CrudRepository

JpaRepository«T, ID extends Serializable> extends PagingAndSortingRepository

Repository, CrudRepository, PagingAndSortingRepository is from spring-data-commons
JpaRepository is from spring-data-jpa


What is CrudRepository?
CrudRepository is an interface provided by Spring data jpa.
In this interface we are having several methods which are used to perform curd operations.
To create user defined repository interface we will extend properties from this CrudRepository interface. 
   public interface ContactMasterRepo extends CrudRepository<T,ID>{}

If we create user defined repository interface, then implementation class will be created in runtime for our user defined repository interface (Proxy class). 

methods available in CurdRepository interface
==============================================
1. Object save(T entity); ```<S extends T> S save(S entity);```
   To insert record into table
   Note : Same method will perform update operation also.
   As the name depicts, the save() method allows us to save an entity to the DB.
   Saving an entity can be performed with the CrudRepository.save(...) method. It persists or merges the given entity by using the
   underlying JPA EntityManager.
   If the entity has not yet been persisted, Spring Data JPA saves the entity with a call to the entityManager.persist(...) method.
   Otherwise, it calls the entityManager.merge(...) method.

2. saveAll(Iterable1e<T> entities);  ```<S extends T> Iterable<S> saveAll(Iterable<S> entities);``` 
   To insert more than one record at a time we can go for this method.
   This method is taking Iterable as a parameter.Iterable is super interface Collection interface.

3. findById(Serializable1e id);  Optional<T> findById(ID id);
   To retrieve record from table using Primary Key Column value we will use this method

4. findAllById(Iterable1e<Serializable1e> ids);  Iterable<T> findAllById(Iterable<ID> ids);
   To retrieve records based on primary key column values we can use this

5. findAll();  Iterable<T> findAll(); 
   To retrieve all records from table

6. long count();
   This method is used to get total no. of rows available in table.

7. existsById(Serializable id); boolean existsById(ID id);
   This method is used to verify record presence in table using PK column value.
   If record presented it will give true else it will give false.

8. deleteById(Serializable id);  void deleteById(ID id); 
   This method is used to delete record based

9. deleteAllById(Iterable1e<Serializable> ids);  void deleteAllById(Iterable<? extends ID> ids); 
   To delete more than one record based on PK column values

10. void deleteAll()
    To delete all records from the table 

11. void delete(T entity);
    pass the entity to delete

12. void deleteAll(Iterable<? extends T> entities);
    pass collection of entity to delete


JpaRepository
=============
What is JpaRepository ?

CrudRepository (Crud operation)
JpaRepository (Crud operations + Pagination + Sorting + QueryByExample)

JpaRepository interface is superior to CrudRepository interface. 
When we compare these two JpaRepository having more functionalities than CrudRepository. 

CrudRepository extending properties from Repository interface. 
CrudRepository interface provided 11 methods

JpaRepository extending properties from below 2 interfaces
   1) PagingAndSortingRepository
   2) QueryByExampleExecutor 

```java
public interface JpaRepository<T, ID> extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T> {

	List<T> findAll();

	List<T> findAll(Sort sort);

	List<T> findAllById(Iterable<ID> ids);

	<S extends T> List<S> saveAll(Iterable<S> entities);

	/**
	 * Flushes all pending changes to the database.
	 */
	void flush();

	/**
	 * Saves an entity and flushes changes instantly.
	 **/
	<S extends T> S saveAndFlush(S entity);

	/**
	 * Saves all entities and flushes changes instantly.
	 */
	<S extends T> List<S> saveAllAndFlush(Iterable<S> entities);

	/**
	 * Deletes the given entities in a batch which means it will create a single query.
	 * method.
	 */
	void deleteAllInBatch(Iterable<T> entities);

	/**
	 * Deletes the entities identified by the given ids using a single query.
	 */
	void deleteAllByIdInBatch(Iterable<ID> ids);

	/**
	 * Deletes all entities in a batch call.
	 */
	void deleteAllInBatch();

	/**
	 * Returns a reference to the entity with the given identifier.
	 */
	T getReferenceById(ID id);

	<S extends T> List<S> findAll(Example<S> example);

	<S extends T> List<S> findAll(Example<S> example, Sort sort);
}

```


SimpleJpaRepository is the handler implementation class for JpaRepository.

Pagination (I)
   findAll(Sort); //retrieve all based on sort
   findAll(Pageable); //retrieve records based on page

JpaRepository extends Pagination. 

Pagination allows the users to see a small portion of data at a time (a page), and sorting allows the users to view the data in a more organized way.
Paging and sorting is mostly required when we are displaying domain data in
tabular format in UI.


Using JpaRepository we can perform 
   findAll(); // retrieve all records
   findAll(Sort); //retrieve all based on sort
   findAll(Pageable); //retrieve records based on page

### Sorting
Sorting consist of two fields - sortBy (single or multiple fields) and sortDir (sort direction can be ASC or DESC).

```java
List<ContactsMasterEntity> list = repository.findAll();
List<ContactsMasterEntity> list = repository.findAll(Sort.by("column_name")).ascending());
List<ContactsMasterEntity> list = repository.findAll(Sort.by("column_name")).descending());
```

### Pagination
What is Pagination? </br>
The process of dividing total records into multiple pages is called pagination. 

Why we need Pagination? <br/>
Using pagination we can display the data which is really required for user. 
Using Pagination we can save server memory
Application looks beautiful.
Number of clicks will increase to application. <br>
**Example** - <br>
   Gmail using pagination to display mails <br>
   Google search engine using pagination to display search results. <br>
   Flipkart loads products using Pagination

How many ways we can implement Pagination?
1. **Server side Pagination** 
   In this approach we will retrieve data from database based on page number. <br>
   For every page load DB query will execute to retrieve page specific data. <br>
   To retrieve page specific data from table we will use Row Number concept in SQL query. <br>
   **Advantages** 
   1. Memory will be saved 
   2. On demand execution  <br>

   **Dis-Advantages**
   1. For every page load db query will execute. 
   
    **If table data is very huge then recommended to implement Server side pagination.**

2. **Client side Pagination** 
   In this approach we will retrieve all records from table at a time & will manage records display at client side.
   There are several JS libraries are available to implement Client Side pagination. <br>
   
   **Advantages**
   1. Only one time query will execute to retrieve all records from table.
   
    **Dis-Advantages**
   1. Server memory will be wasted 
   
   **If table data is less, then we can implement Client Side pagination.** 

Which type of pagination is recommended in project? <br>
When we are implementing pagination, first we should decide the **page size**. <br>
Page Size means the number of record should be displayed in a page.
1. Gmail page size 50 records
2. Google page size 10 records
3. Flipkart page size 17 records

We should identify how many records are available in table (using count function we can get this info). With Page Size & Total Records we should identify number of pages required.

**Example** 
We have 5000 available records. Our page size is 15 records. We have to identify for how many pages we need in order to display 5000 records. 

**Note** 
We should not hard code total pages required in pagination. We need to identify total pages based on page Size and total records available in table.

How to calculate total pages required in pagination ? <br>
pageSize = totalRecords/pageSize

**page size = 5** <br>
**TestCase-1** -> totalRecords = 10, pageSize = 10/5 = 2 pages <br>
**TestCase-2** -> totalRecords = 20, pageSize = 20/5 = 4 pages <br>
**TestCase-3** -> totalRecords = 40, pageSize = 40/5 = 8 pages <br>
**TestCase-4** -> totalRecords = 22, pageSize = 22/5 = 4.4 pages [Here Formula failed] 

#### _Modified formula_ 
**pageSize = (totalRecords/pageSize) + ((totalRecords%pageSize) > 0 ? 1 : 0);**

**pageSize = 5** <br> 
**TestCase-1 ->** totalRecords = 10 , pageSize = (10/5) + ((10%5) > 0 ? 1 : 0) ; result = 2  + 0   =  2 total pages 

**TestCase-2 ->** totalRecords = 15 , pageSize = (15/5) + ((15%5) > 0 ? 1 : 0) ; result = 3  + 0   = 3 total pages 

**TestCase-3 ->** totalRecords = 45 , pageSize = (45/5) + ((45%5) > 0 ? 1 : 0) ; result = 9  + 0   = 9 total pages

**TestCase-2 ->** totalRecords = 22 , pageSize = (22/5) + ((22%5) > 0 ? 1 : 0) ; result = 4  + 1   = 5 total pages

**Working with Pagination using JpaRepository?** <br>
To read data from table using JpaRepository we have below methods 
- findById(Serializable id)
- findAllById(Iterable<Serializable> ids)
- findAll()

Below methods are providing by PagingAndSortingRepository  
findAll(Sort s) -> to sort records
findAll(Pageab1e p) -> retrieve page record

When we are working with pagination in Data JPA we need to create Pageable object with below values
1. pageNo
2. PageSize

Pageable p = PageRequest.of(pageNo, pageSize); <br>

**Note :** pageNo will come dynamically from UI & pageSize is fixed value. In Spring-data-jpa page number starts with 0. 

Page pageData = repository.findAll(Pageable p); <br> 
int totalPages = pageData.getTotalPages(); <br>
pageData.getContent(); 

**PageRequest** is class acts as factory for creating the object of Pageable. PageRequest has a static factory method called of(int pageNo,int pageSize).

```java
interface JpaRepository extends PagingAndSortingRepository {}
interface AccountRepository extends JpaRepository {}

Pageable pageable = PageRequest.of(3, 10);
Page<T> page = accountRepository.findAll(pageable);
List<T> listEntity = page.getContent(); 
listEntity.stream().forEach(System.out::println);

accountRepository.findAll([Sort.by](http://sort.by/)("zip"));
```



We can use together Pageable & sort using below: <br>
accountRepository.findAll(PageRequest.of(3, 10).sort([Sort.by](http://sort.by/)("zip")));


PROJECTION in data-jpa 
=======================
Spring Data JPA Multi-Database Application
==========================================
Spring Boot Data JPA by default supports connecting with One Database.
Database connection Configuration (AutoConfigured) is given by Spring Boot only.
We need to pass inputs using either properties (or) yml.
	Like: driver class url username password show-sql dialect ddl-auto etc. 

(**)This time i want to to multiple databases.
We need to define below objects(Beans) in order:
	DataSource
	EntityManagerFactory
	TransactionManager
By using Spring Java Configuration Style. 

Db#1-PostgresDb
cmd> psql -U postgres
cmd> create database sample
cmd> \l  #(list all dbs)
cmd> \c  #(connect to one db)
cmd> \dt #(all tables)

Db#2-MySQL
cmd> enter pwd : root
cmd> create database abcd
cmd> show databases
cmd> use abcd

Spring Boot and H2 in memory database
=====================================
data-jpa
h2-database dependencies 

