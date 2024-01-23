persistence.xml

<persistence xmlns="http://xmlns.jcp.org/xml/ns/persistence" version="2.2">
    <persistence-unit name="PersistenceUnit">
        <description>Hibernate JPA Demo</description>
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <properties>
            <property name="javax.persistence.jdbc.Driver" value="com.mysql.cj.jdbc.Driver"/>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/demo" />
            <property name="javax.persistence.jdbc.user" value="web" />
            <property name="javax.persistence.jdbc.password" value="12345678" />
            <property name="hibernate.show_sql" value="true" />
            <property name="hibernate.format_sql" value="true" /> 
            <property name="hibernate.hbm2ddl.auto" value="update"/>
        </properties>
    </persistence-unit>
</persistence>