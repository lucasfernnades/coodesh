## SQL

Query to return number of employees separated by gender:

- **SELECT gender, Count(*) as quantidade from employees group by gender**
   
Query to return number of different employees separated by gender, hire_date and birth_date:

- **SELECT gender, hire_date, birth_date, COUNT(DISTINCT emp_no) FROM employees em group by gender, hire_date, birth_date;**

Query to return the average salary, minimum salary and maximum salary by gender
- **SELECT em.gender, MIN(s.salary) as Min_Salary, MAX(s.salary) as Max_Salary, AVG(s.salary) as Avg_salary from employees em JOIN salaries s ON em.emp_no = s.emp_no GROUP BY em.gender;**

## Graphic
![Graphic cpu-memory](https://github.com/lucasfernnades/coodesh/assets/74213689/31e088dc-d934-4c68-8178-a8781cf1650c)
- É possivel observarmos que há uma utilização maior de memoria e da gpu em horarios padrões, isso ocorre provavelmente devido a rotinas pré estabelecidas que rodam alguma funcionalidade e causam esse custo de uso diário.

![graphic client side full page load](https://github.com/lucasfernnades/coodesh/assets/74213689/d52d1f14-c3fa-48ed-bda1-e67aad899c9c)
- Analisando esse grafico podemos perceber que a maioria das requisições de acesso do lado do cliente ao acessar o website em questão apresenta uma maior demora para que aconteça o carregamento completo da página acessada.

Com isso é possível entender o quanto de memória está sendo usado, encontrar padrões de quantidade de acesso/login em determinado horário, e identificar a quantidade de carregamentos rápidos e lentos que estão ocorrendo.
Assim, seria possível fazer ligações entre os gráficos, para poder entender melhor, o que poderia ocasionar a demora do carregamento da pagina no lado do cliente, se as suport calls tem relação com o processamento lento do website,
se nesse período ocorreu muitas requisições em dado servidor ou se está acontecendo muitos acessos, ou muitas requisições de armazenamento de dados.

## Any Text
Me chamo Lucas, resido em Limeira-SP e atualmente moro com minha namorada e meus dois cachorros, Peter e Beth.

Adotei meus cachorros ano passado, 2023, ambos huskies, uma raça que sempre tive vontade de ter. Não é uma raça simples de se adotar, ainda mais que eles já tinham 6 anos. Logo de início já tive que ir atrás de adestrador, para conseguir fazer esse processo se tornar o menos doloroso para eles. Hoje, Peter e Beth são bem apegados, e é uma grande responsabilidade cuidar deles.

Meu hobby preferido é jogar basquete. Aos sábados sempre vou jogar em quadras abertas. Comecei indo com um amigo, e hoje temos um grupo com diversas pessoas que também frequentam essas quadras. Eu sempre fui mais de ficar em casa, jogando online com amigos, acabou que encontrar esse esporte me fez muito bem, me ajudou a melhorar meu condicionamento físico e me afastar um pouco das telas.

Tenho interesse também em jogos de computador, como league of legends, pw e valorant. Recentemente tenho jogado mais pw, um jogo online, onde você vai melhorando seu personagem, joga com outras pessoas, inclusive estou em um clã com várias pessoas, onde temos até mesmo reuniões para podermos participar de alguns eventos. 

E por vezes, gosto de sair com amigos para algum evento, ir comer fora, ou mesmo chamar para vir em casa para conversamos. 

Por fim, espero que tenha lhe dado um entendimento melhor sobre quem sou, e sempre podemos nos conhecer melhor quando fizer parte do time, pela qual estou ansioso em poder contribuir e aprender com os desafios. Agradeço a oportunidade e mal posso esperar para começar.
