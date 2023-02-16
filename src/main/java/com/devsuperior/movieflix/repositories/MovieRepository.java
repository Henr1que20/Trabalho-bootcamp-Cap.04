package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.projection.ReviewProjetion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    /*
    *
    * tentei criar as busca com o jpql, mas estava dando esse erro, so consegui resolver usando a query natiiva sql
    *
org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'movieRepository' defined in com.devsuperior.movieflix.repositories.MovieRepository defined in @EnableJpaRepositories declared on JpaRepositoriesRegistrar.EnableJpaRepositoriesConfiguration: Invocation of init method failed; nested exception is java.lang.IllegalArgumentException: Validation failed for query for method public abstract java.util.List com.devsuperior.movieflix.repositories.MovieRepository.findAll(org.springframework.data.domain.Pageable,java.lang.Long)!
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1786) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:602) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:524) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:925) ~[spring-beans-5.3.5.jar:5.3.5]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918) ~[spring-context-5.3.5.jar:5.3.5]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-5.3.5.jar:5.3.5]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:144) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:769) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:761) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:426) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:326) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1313) ~[spring-boot-2.4.4.jar:2.4.4]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[spring-boot-2.4.4.jar:2.4.4]

    * */


    @Query(value = "SELECT * FROM TB_MOVIE m where m.genre_id = :genreId", nativeQuery = true)
    Page<Movie> find(Pageable pageable, Long genreId);

    @Query(value = "SELECT * FROM TB_MOVIE m", nativeQuery = true)
    Page<Movie> find(Pageable pageable);

    @Query(value = "SELECT * from tb_movie m where m.id = :id", nativeQuery = true)
    Optional<Movie> findMovieById(Long id);

    @Query(value = "select  r.ID, r.TEXT, u.NAME from TB_REVIEW r inner join TB_MOVIE m on r.REVIEW_ID = m.id  inner join TB_USER u on r.USER_ID = u.id where m.id = :movieId", nativeQuery = true)
    List<ReviewProjetion> findReview(Long movieId);
}
