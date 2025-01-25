# Verificador de Anagramas Usando Contagem de Caracteres

## Descrição do Problema

A tarefa é determinar se duas strings são anagramas uma da outra. Um anagrama é uma palavra ou frase formada pela reorganização das letras de outra. Por exemplo, "listen" é um anagrama de "silent".

### Restrições:
- Ambas as strings são consideradas não-nulas.
- Ambas as strings contêm apenas caracteres alfabéticos (ignorando espaços, pontuação, etc.).
- O comprimento das strings é importante. Se as strings tiverem comprimentos diferentes, não podem ser anagramas.

## Abordagem

A ideia básica é verificar se ambas as strings possuem os mesmos caracteres com a mesma frequência. Se duas strings são anagramas, elas devem ter os mesmos caracteres e esses caracteres devem aparecer o mesmo número de vezes em ambas as strings.

### Etapas:
1. **Verificar se as strings têm comprimentos diferentes**: Se elas não tiverem o mesmo comprimento, elas não podem ser anagramas, então retorne falso imediatamente.
2. **Contagem de Caracteres**:
    - Use uma estrutura de dados, como um `HashMap`, para contar a frequência de cada caractere na primeira string.
    - Percorra a segunda string e diminua a contagem para cada caractere.
    - Se, no final, todas as contagens forem zero, as strings são anagramas; caso contrário, não são.

### Complexidade de Tempo e Espaço:
- **Complexidade de Tempo**: O(n) - Percorremos cada string uma vez, onde `n` é o comprimento das strings.
- **Complexidade de Espaço**: O(1) - Usamos um mapa de tamanho fixo para armazenar as contagens de caracteres (espaço constante para as 26 letras do alfabeto).

## Explicação do Código:
O programa utiliza um `HashMap` para contar a frequência dos caracteres da primeira string. Em seguida, verifica se cada caractere da segunda string existe no mapa e tem a mesma frequência. Se todos os caracteres coincidirem e suas contagens estiverem balanceadas, as strings são anagramas.

### Exemplo:
Entrada: `"listen"`, `"silent"`

- Ambas as strings têm comprimento 6, então procedemos com a contagem dos caracteres.
- Para `"listen"`, contamos cada caractere e armazenamos a contagem no `HashMap`:
    - 'l' -> 1, 'i' -> 1, 's' -> 1, 't' -> 1, 'e' -> 1, 'n' -> 1
- Para `"silent"`, diminuímos a contagem para cada caractere:
    - 's' -> 0, 'i' -> 0, 'l' -> 0, 'e' -> 0, 'n' -> 0, 't' -> 0
- Todas as contagens são zero, significando que as strings são anagramas.

### Performance:
- O programa executa em tempo **O(n)**, onde `n` é o comprimento das strings de entrada, pois percorremos cada string uma vez.
- A complexidade de espaço é **O(1)**, pois o `HashMap` usado para contar os caracteres tem tamanho fixo (26 caracteres para o alfabeto).

## Conclusão:
Esta solução fornece uma maneira eficiente de verificar anagramas por meio da contagem da frequência dos caracteres. O algoritmo funciona em tempo linear e usa espaço constante, tornando-o adequado para grandes tamanhos de entrada.

# Verificador de Anagramas Usando Ordenação

## Descrição do Problema

A tarefa é determinar se duas strings são anagramas uma da outra. Um anagrama é uma palavra ou frase formada pela reorganização das letras de outra. Por exemplo, "listen" é um anagrama de "silent".

### Restrições:
- Ambas as strings são consideradas não-nulas.
- Ambas as strings contêm apenas caracteres alfabéticos (ignorando espaços, pontuação, etc.).
- O comprimento das strings é importante. Se as strings tiverem comprimentos diferentes, não podem ser anagramas.

## Abordagem

A ideia básica por trás dessa abordagem é que se duas strings são anagramas, elas devem conter os mesmos caracteres nas mesmas frequências. Portanto, se ordenarmos ambas as strings, suas versões ordenadas devem ser idênticas se as strings forem anagramas.

### Etapas:
1. **Verificar se as strings têm comprimentos diferentes**: Se elas não tiverem o mesmo comprimento, elas não podem ser anagramas, então retorne falso imediatamente.
2. **Ordenar ambas as strings**: Ordene ambas as strings alfabeticamente.
3. **Comparar as strings ordenadas**: Após ordenar, se as strings forem anagramas, suas versões ordenadas devem ser idênticas. Se forem idênticas, as strings são anagramas; caso contrário, não são.

### Complexidade de Tempo e Espaço:
- **Complexidade de Tempo**: A complexidade de tempo dessa abordagem é dominada pela etapa de ordenação, que é **O(n log n)**, onde `n` é o comprimento das strings. Após a ordenação, a comparação das duas strings leva **O(n)** de tempo.
- **Complexidade de Espaço**: A complexidade de espaço depende do algoritmo de ordenação. Se usar um algoritmo de ordenação in-place (como o QuickSort), a complexidade de espaço é **O(1)**, caso contrário, pode ser **O(n)** para algoritmos como o MergeSort que exigem espaço adicional.

## Explicação do Código:
O programa usa o método `Arrays.sort()` para ordenar ambas as strings de entrada. Após a ordenação, ele compara as versões ordenadas das strings. Se as strings ordenadas forem idênticas, então as strings originais são anagramas.

### Exemplo:
Entrada: `"listen"`, `"silent"`

- Ambas as strings têm comprimento 6, então procedemos com a ordenação das strings.
- Ordenando "listen" obtemos `"eilnst"`.
- Ordenando "silent" obtemos `"eilnst"`.
- Ambas as strings ordenadas são idênticas, então as strings são anagramas.

### Performance:
- O programa executa em tempo **O(n log n)**, onde `n` é o comprimento das strings de entrada, pois a etapa de ordenação domina a complexidade de tempo.
- A complexidade de espaço é **O(1)** ou **O(n)**, dependendo do algoritmo de ordenação utilizado.

## Conclusão:
Esta solução fornece uma maneira eficiente e simples de verificar anagramas por meio da ordenação das strings. O algoritmo funciona em tempo **O(n log n)** devido à etapa de ordenação e é fácil de entender e implementar.


# Análise de Big O

## Descrição do Problema

A notação Big O é usada para descrever o desempenho ou a complexidade de um algoritmo em termos de tempo ou espaço. Ela ajuda a analisar como o tempo de execução ou os requisitos de memória crescem à medida que o tamanho da entrada aumenta.

Neste exemplo, vamos examinar a complexidade de tempo de diferentes tipos de funções:

- **O(1) (tempo constante)**: O tempo de execução é constante e não depende do tamanho da entrada.
- **O(n) (tempo linear)**: O tempo de execução cresce linearmente com o tamanho da entrada.
- **O(n^2) (tempo quadrático)**: O tempo de execução cresce quadraticamente com o tamanho da entrada.

Vamos implementar três funções com diferentes complexidades de tempo e analisar como o tempo de execução muda com o tamanho da entrada. Além disso, vamos simular um método para medir o tempo gasto por essas funções para diferentes tamanhos de entrada.

### Exemplos de Funções:
- **Função 1**: Complexidade O(1)
- **Função 2**: Complexidade O(n)
- **Função 3**: Complexidade O(n^2)

### Abordagem:
1. **O(1) - Complexidade de Tempo Constante**:
    - Essa função realiza uma operação de tempo constante que não depende do tamanho da entrada. Por exemplo, acessar um elemento em um array.

2. **O(n) - Complexidade de Tempo Linear**:
    - Essa função itera sobre a entrada, realizando uma operação para cada elemento. A complexidade de tempo cresce linearmente com o tamanho da entrada.

3. **O(n^2) - Complexidade de Tempo Quadrática**:
    - Essa função envolve laços aninhados. O tempo de execução cresce quadraticamente com o tamanho da entrada, pois o laço interno executa `n` vezes para cada iteração do laço externo.

### Medição de Performance:
O programa usa `System.nanoTime()` para medir o tempo gasto por cada uma das funções. Isso nos permite observar a diferença no tempo de execução para diferentes complexidades de tempo.

### Complexidade de Tempo e Espaço:
- **O(1)**: Complexidade de tempo constante significa que o tempo de execução da função permanece o mesmo, independentemente do tamanho da entrada.
- **O(n)**: Complexidade de tempo linear significa que o tempo de execução da função cresce diretamente proporcional ao tamanho da entrada.
- **O(n^2)**: Complexidade de tempo quadrática indica que o tempo de execução da função cresce quadraticamente com o tamanho da entrada.

### Análise de Exemplos:

- **Exemplo O(1)**:
    - Esta função acessa um elemento em um array. O tempo para acessar é constante, independente do tamanho do array.

- **Exemplo O(n)**:
    - Esta função imprime cada elemento de um array. À medida que o tamanho do array aumenta, o tempo de execução aumenta linearmente.

- **Exemplo O(n^2)**:
    - Esta função imprime pares de índices para uma estrutura bidimensional. O tempo de execução cresce quadraticamente devido aos laços aninhados.

### Aplicações no Mundo Real:
- **O(1)**: Operações como acessar um elemento em um array ou realizar uma busca em um mapa hash.
- **O(n)**: Funções que processam cada elemento de uma coleção, como pesquisar em uma lista.
- **O(n^2)**: Algoritmos com iterações aninhadas, como o bubble sort ou multiplicação de matrizes.

### Observação de Performance:
A medição de performance dependerá da carga do sistema e do hardware. No entanto, o ponto-chave é a relação entre o tamanho da entrada `n` e o tempo de execução, o que ilustra a importância da notação Big O na análise da eficiência de algoritmos.

# Árvore de Busca Binária (BST)

## Descrição do Problema

Uma **Árvore de Busca Binária (BST)** é uma estrutura de dados onde cada nó tem no máximo dois filhos, referidos como filho esquerdo e filho direito. A principal propriedade de uma BST é que o valor do filho esquerdo é menor do que o valor do nó pai, e o valor do filho direito é maior do que o valor do nó pai.

A **Árvore de Busca Binária** permite operações eficientes como busca, inserção e exclusão, aproveitando a propriedade da BST.

### Operações Principais:
1. **Inserção**: Inserir um novo nó na BST, mantendo a propriedade da BST. O novo nó é colocado na subárvore esquerda ou direita com base no valor comparado ao nó atual.
2. **Busca**: Buscar um valor específico na BST. Comece pela raiz e navegue para a esquerda ou direita com base nas comparações, utilizando a propriedade da BST para guiar a busca.
3. **Exclusão**: Excluir um nó da BST. A exclusão é mais complexa porque depende de o nó ter 0, 1 ou 2 filhos.

### Complexidade de Tempo:
- **Busca**: O(h), onde `h` é a altura da árvore. No melhor caso, se a árvore estiver balanceada, a altura é O(log n). No pior caso, se a árvore for inclinada, a altura pode ser O(n).
- **Inserção**: O(h), pois podemos precisar percorrer da raiz até uma folha para inserir o novo nó.
- **Exclusão**: O(h), pois a exclusão requer ajustar a estrutura da árvore e pode envolver percorrer até o nó que precisa ser excluído.

### Complexidade de Espaço:
- A complexidade de espaço é O(n), onde `n` é o número de nós armazenados na árvore.

## Explicação do Código

### Classe `Node`:
A classe `Node` representa um único nó na árvore de busca binária. Cada nó contém:
- Um valor (`value`).
- Uma referência para o filho esquerdo (`left`).
- Uma referência para o filho direito (`right`).

### Método `insert`:
- Esse método insere um novo nó na BST. Ele chama o método auxiliar `insertRecursively`, que realiza a inserção de forma recursiva.
- Se o nó atual for `null`, ele cria um novo nó com o valor fornecido.
- Caso contrário, ele compara o valor com o valor do nó atual e insere o nó recursivamente na subárvore esquerda ou direita.

### Método `inOrderTraversal`:
- Esse método realiza uma **travessia em ordem** da árvore. A travessia em ordem visita os nós em ordem crescente (subárvore esquerda, raiz, subárvore direita).
- O método auxiliar `inOrderRecursively` é chamado recursivamente para percorrer a subárvore esquerda, imprimir o valor do nó e depois percorrer a subárvore direita.

## Exemplo:

Considere a seguinte sequência de inserções de nós: [50, 30, 20, 40, 70, 60, 80]. A BST resultante seria:

### Exemplos de Códigos de Moeda Suportados:
- **USD**: Dólar dos Estados Unidos (moeda base)
- **EUR**: Euro
- **GBP**: Libra Esterlina
- **JPY**: Iene Japonês
- **AUD**: Dólar Australiano

### Complexidade de Tempo:
- **Pesquisa de Taxa de Câmbio**: O acesso aos valores de taxas de câmbio no `HashMap` é uma operação O(1) (tempo constante).

### Conclusão:
Este conversor de moeda fornece uma solução simples e eficaz para conversões de moedas entre um conjunto limitado de moedas. Em um ambiente de produção, seria necessário integrar com uma API de câmbio em tempo real para obter taxas de câmbio atualizadas e fornecer suporte a um maior número de moedas.

# Dining Philosophers Problem

## Problem Description

O **Problema dos Filósofos Jantando** é um problema clássico de sincronização onde um grupo de filósofos está sentado ao redor de uma mesa, com um garfo à esquerda e à direita de cada um. Cada filósofo alterna entre pensar e comer, mas precisa de ambos os garfos para comer. O desafio é evitar **deadlock** (onde todos os filósofos ficam esperando pelos garfos e não conseguem avançar) e **starvation** (onde alguns filósofos nunca conseguem comer).

### Abordagem:
- O problema é resolvido usando **locks** para sincronizar o acesso aos recursos compartilhados (os garfos).
- Cada filósofo possui dois garfos: um à esquerda e um à direita. Os filósofos precisam de ambos os garfos para comer.
- Para evitar deadlock, os filósofos pegam o garfo da esquerda primeiro e o garfo da direita depois. Isso evita que todos fiquem esperando por um garfo, sem conseguir pegar o segundo.
- Se um filósofo não conseguir pegar ambos os garfos (por exemplo, se o garfo da direita já estiver sendo usado), ele libera o garfo da esquerda e tenta novamente, garantindo justiça e evitando deadlock.
- Os filósofos alternam continuamente entre pensar e comer.

### Requisitos:
- O sistema deve garantir que nenhum dois filósofos possam comer ao mesmo tempo, pois eles precisam de acesso exclusivo aos seus garfos.
- O sistema deve evitar deadlocks e starvation, garantindo que todos os filósofos tenham uma oportunidade justa de pegar ambos os garfos.

## Explicação do Código

### Estrutura de Dados:
- **forks**: Um array de **Locks** que representa os garfos. Cada garfo é associado a um filósofo e é controlado por um lock para garantir que apenas um filósofo possa pegar o garfo por vez.
- **numPhilosophers**: O número total de filósofos e, consequentemente, o número de garfos.

### Método `think`:
- Este método simula o filósofo pensando. Durante este tempo, o filósofo não interage com os garfos.
- **Entrada**:
    - `philosopherId`: O identificador único do filósofo.
- O filósofo "pensa" por um tempo simulado de 1 segundo.

### Método `eat`:
- Este método simula o filósofo comendo. Durante este tempo, o filósofo mantém os garfos e come.
- **Entrada**:
    - `philosopherId`: O identificador único do filósofo.
- O filósofo "come" por um tempo simulado de 1 segundo.

### Método `dine`:
- O filósofo alterna entre pensar e comer.
- O filósofo começa pensando, depois tenta pegar os garfos.
    - Primeiro, pega o garfo da esquerda.
    - Depois, tenta pegar o garfo da direita.
- Se conseguir pegar ambos os garfos, o filósofo come.
- Após comer, os garfos são liberados, permitindo que outros filósofos possam usá-los.

### Método `main`:
- Cria um número especificado de filósofos e cria um thread para cada filósofo.
- Cada thread executa o ciclo contínuo de pensar e comer, simulando a interação entre os filósofos.

### Tratamento de Erros:
- O código não possui erros explícitos no fluxo principal, mas qualquer thread pode ser interrompida por uma exceção `InterruptedException`, que é tratada e o thread é interrompido adequadamente.

### Possíveis Melhorias:
- **Prevenção de Starvation**: A abordagem de pegar o garfo da esquerda primeiro pode ser melhorada com alguma forma de escalonamento, como a implementação de uma fila de espera para garantir que todos os filósofos tenham uma chance justa de pegar os garfos.
- **Monitoramento e Debugging**: Para fins de monitoramento, seria útil adicionar logs detalhados sobre a quantidade de tempo que os filósofos passam pensando e comendo, bem como o estado atual de cada garfo.

## Exemplo de Execução

O programa simula a interação de filósofos com garfos. A saída pode ser parecida com:


### Complexidade de Tempo:
- Cada filósofo realiza um ciclo de ações (pensando, pegando garfos, comendo, soltando garfos) repetidamente.
- Cada ação dentro do ciclo (pensar, pegar garfos, comer) tem tempo constante O(1), mas como cada filósofo executa o ciclo em um loop infinito, o tempo total depende do número de filósofos e das iterações.

### Complexidade de Espaço:
- A complexidade de espaço é O(N), onde N é o número de filósofos, pois é necessário armazenar um lock para cada garfo.

## Conclusão

Este programa oferece uma solução simples para o **Problema dos Filósofos Jantando**, utilizando locks para evitar deadlock e garantir a sincronização entre os filósofos. Em uma versão mais avançada, técnicas de escalonamento e maior monitoramento poderiam ser implementadas para melhorar a equidade entre os filósofos e evitar starvation.

# Fibonacci com Programação Dinâmica (FibonacciDP)

## Descrição do Problema

A **sequência de Fibonacci** é uma série de números onde cada número é a soma dos dois números anteriores, começando de 0 e 1. A sequência segue a seguinte fórmula:

- F(0) = 0
- F(1) = 1
- F(n) = F(n-1) + F(n-2) para n > 1

A sequência de Fibonacci é amplamente utilizada em problemas algorítmicos e computacionais devido à sua estrutura recursiva simples. O desafio é calcular eficientemente o n-ésimo número dessa sequência, especialmente para valores grandes de `n`.

### Objetivo:
Dado um inteiro `n`, retorne o n-ésimo número na sequência de Fibonacci.

## Abordagem

### Recursão Simples
A maneira mais simples de calcular o número de Fibonacci é usar uma abordagem recursiva direta, onde calculamos `F(n-1)` e `F(n-2)` de forma recursiva até alcançarmos os valores base (0 e 1). No entanto, essa abordagem é ineficiente, pois há muitos cálculos redundantes.

### Programação Dinâmica (Memoização)
Para otimizar a solução, usamos **programação dinâmica** com **memoização**. A ideia central é armazenar os resultados intermediários para evitar que a função precise recalcular o valor de Fibonacci para os mesmos índices múltiplas vezes.

### Passos:
1. Usamos uma estrutura de dados (como um mapa) para armazenar os números de Fibonacci já calculados.
2. A função recursiva calcula o número de Fibonacci de forma recursiva e verifica se o valor já foi calculado anteriormente. Caso já tenha sido calculado, ele é retornado diretamente.
3. Caso contrário, a função calcula o número e o armazena para uso futuro.

### Complexidade de Tempo:
A complexidade de tempo do algoritmo é **O(n)**. Isso ocorre porque cada número de Fibonacci é calculado uma única vez e armazenado. Portanto, o tempo total para calcular o n-ésimo número de Fibonacci é linear em relação ao valor de `n`.

### Complexidade de Espaço:
A complexidade de espaço é **O(n)**, pois armazenamos todos os números de Fibonacci até o valor de `n` para evitar cálculos redundantes. Embora isso otimize o tempo de execução, o espaço necessário para armazenar os resultados intermediários cresce linearmente com `n`.

### Possíveis Otimizações:
Embora o algoritmo com memoização seja eficiente, podemos otimizar ainda mais a memória necessária. Uma possível otimização seria armazenar apenas os dois últimos números da sequência, já que para calcular o próximo número, apenas os dois anteriores são necessários. Isso reduziria a complexidade de espaço para **O(1)**.

### Exemplo de Execução:

Suponha que queremos calcular o número de Fibonacci na posição 6. A sequência de Fibonacci seria:

0, 1, 1, 2, 3, 5, 8

Portanto, o número de Fibonacci na posição 6 é 8.

### Conclusão:

Este algoritmo resolve o problema de calcular o n-ésimo número de Fibonacci de forma eficiente utilizando **programação dinâmica**. A técnica de **memoização** ajuda a evitar o custo computacional de cálculos redundantes e melhora significativamente o desempenho em comparação com uma abordagem recursiva simples. Para valores grandes de `n`, essa abordagem é essencial para garantir que o cálculo seja feito de maneira eficiente e rápida.

# Problema da Mochila Fracionada (Fractional Knapsack)

## Descrição do Problema

O **Problema da Mochila Fracionada** é uma variação do problema clássico da mochila, onde você pode pegar frações de um item, em vez de ser necessário pegar o item inteiro. O objetivo é maximizar o valor total dos itens colocados na mochila, dado que cada item possui um peso e um valor.

### Objetivo:
Dado um limite de peso `W` para a mochila e uma lista de `n` itens, cada um com um peso `wi` e valor `vi`, determine o valor máximo que pode ser obtido ao colocar itens na mochila. Você pode pegar quantidades fracionárias dos itens, ou seja, se não conseguir carregar o item inteiro, pode pegar uma fração dele.

## Abordagem

### Abordagem Gananciosa
O problema da mochila fracionada pode ser resolvido utilizando uma abordagem **gananciosa** (greedy). A ideia é selecionar os itens com base na relação valor/peso (valor por unidade de peso), escolhendo primeiro os itens com a maior relação valor/peso.

### Passos:
1. Calcule a relação valor/peso para cada item.
2. Ordene os itens em ordem decrescente de sua relação valor/peso.
3. Selecione os itens seguindo a ordem dos itens classificados:
    - Se o item puder ser totalmente colocado na mochila, coloque-o completamente.
    - Se o item não puder ser colocado completamente, coloque a fração que caiba na mochila.
4. Pare quando a mochila estiver cheia ou todos os itens tiverem sido considerados.

### Complexidade de Tempo:
- O tempo necessário para ordenar os itens é **O(n log n)**, onde `n` é o número de itens.
- O tempo necessário para selecionar os itens é **O(n)**.
- A complexidade de tempo geral é **O(n log n)** devido à ordenação.

### Complexidade de Espaço:
- A complexidade de espaço é **O(n)** devido ao armazenamento dos itens e suas respectivas relações valor/peso.

### Exemplo:
Dado o seguinte conjunto de itens e capacidade da mochila:

- **Capacidade da mochila (W)** = 50
- **Itens** = [(60, 10), (100, 20), (120, 30)] onde cada tuplo representa (valor, peso)

A relação valor/peso para cada item é [6, 5, 4]. Logo, a abordagem gananciosa começa escolhendo o item com a maior relação (item 1), seguido pelo item 2, e, finalmente, pega uma fração do item 3 para completar a capacidade da mochila. O valor máximo obtido seria 240.

### Conclusão:
Este algoritmo resolve o problema da mochila fracionada de forma eficiente utilizando a abordagem gananciosa. Ao ordenar os itens com base na relação valor/peso, o algoritmo seleciona de forma ótima os itens ou frações dos itens a serem incluídos na mochila para maximizar o valor total. O algoritmo é eficiente, com complexidade **O(n log n)**, sendo adequado para problemas de otimização em que as frações dos itens podem ser tomadas.

# Representação de Grafo com Lista de Adjacência e Travessia BFS

## Descrição do Problema

Este problema envolve a **representação de um grafo** usando uma **lista de adjacência** e a implementação do algoritmo **Breadth-First Search (BFS)** para percorrer o grafo. O objetivo é explorar todos os vértices de um grafo de maneira nivelada, ou seja, visitando primeiro todos os vizinhos de um nó antes de explorar seus vizinhos.

## Objetivo

- Representar um grafo não direcionado usando uma lista de adjacência.
- Implementar a travessia do grafo usando **Breadth-First Search (BFS)**, que visita todos os nós ao nível de profundidade antes de avançar para o próximo nível.

## Representação do Grafo

- O grafo é representado usando uma lista de adjacência, onde cada nó possui uma lista de todos os nós aos quais está diretamente conectado (seus vizinhos).
- Para cada vértice, a lista de adjacência contém os vértices adjacentes.

### Algoritmo de Travessia BFS (Breadth-First Search)

O **BFS** percorre o grafo de forma "nivelada", começando por um nó específico e visitando todos os seus vizinhos antes de passar para os vizinhos dos vizinhos. O algoritmo usa uma fila para manter a ordem de visitação e um conjunto para garantir que cada nó seja visitado uma única vez.

## Passos

1. **Criação do Grafo**:
    - Defina um grafo usando uma lista de adjacência.
    - Cada nó no grafo tem uma lista de nós adjacentes.

2. **Implementação do BFS**:
    - Inicialize uma fila para armazenar os nós a serem visitados.
    - Utilize um conjunto para marcar os nós que já foram visitados.
    - Comece pelo nó inicial, marque-o como visitado e adicione-o à fila.
    - Enquanto houver nós na fila, remova um nó, explore seus vizinhos e adicione-os à fila se ainda não foram visitados.

3. **Finalização**:
    - A BFS continua até que todos os nós acessíveis tenham sido visitados.

## Complexidade

- **Complexidade de Tempo**: O(V + E), onde:
    - O(V) para visitar cada vértice.
    - O(E) para explorar todas as arestas.

- **Complexidade de Espaço**: O(V), que é o espaço necessário para armazenar o grafo e o conjunto de visitados.

## Exemplo

Considere o seguinte grafo:

0 -- 1 | | 3 -- 2

A lista de adjacência seria:

- **0** -> [1, 3]
- **1** -> [0, 2]
- **2** -> [1, 3]
- **3** -> [0, 2]

A execução da BFS a partir do nó **0** irá resultar na seguinte ordem de visitação: **0 -> 1 -> 3 -> 2**.

## Conclusão

A BFS é um algoritmo eficiente para percorrer grafos, especialmente útil quando precisamos explorar os nós em camadas. Ele é amplamente utilizado em problemas de busca em grafos, como encontrar o caminho mais curto, verificar conexões em redes e muitas outras aplicações em ciência da computação.

# Demonstração do Uso de Fila de Prioridade (Min-Heap) em Java

## Descrição do Problema

Este problema demonstra o uso de uma **Fila de Prioridade (Min-Heap)** em Java. Uma fila de prioridade é uma estrutura de dados que opera de forma semelhante a uma fila normal, mas com a característica adicional de que cada elemento tem uma prioridade associada a ele. Em uma fila de prioridade baseada em **Min-Heap**, o elemento com a menor prioridade (ou seja, o menor valor) está sempre na frente da fila, pronto para ser processado.

## Objetivo

O objetivo deste problema é demonstrar como usar uma **Fila de Prioridade (Min-Heap)** em Java para realizar operações eficientes de inserção e remoção de elementos com base na sua prioridade.

## Min-Heap

- Um **Min-Heap** é uma árvore binária completa onde o valor de cada nó é menor ou igual aos valores de seus filhos.
- Em uma fila de prioridade baseada em **Min-Heap**, o elemento com o menor valor (ou prioridade) é sempre removido primeiro.
- A **PriorityQueue** do Java é implementada usando um heap, permitindo resolver problemas como encontrar o k-ésimo menor ou maior elemento, ordenar ou agendar tarefas com base na prioridade.

## Classe `PriorityQueue` em Java

O Java fornece a classe `PriorityQueue`, que implementa um **Min-Heap** por padrão. Ela faz parte do pacote `java.util` e permite a inserção e remoção eficientes de elementos com base na sua ordem natural ou um comparador fornecido.

### Métodos da `PriorityQueue`:

- **`add()`**: Adiciona um elemento à fila de prioridade.
- **`peek()`**: Recupera o primeiro elemento da fila de prioridade (o elemento com a menor prioridade) sem removê-lo.
- **`poll()`**: Recupera e remove o primeiro elemento da fila de prioridade.
- **`isEmpty()`**: Verifica se a fila de prioridade está vazia.

## Complexidade

- **Complexidade de Tempo**:
    - A complexidade para inserção (`add()`) e remoção (`poll()`) é **O(log n)**, onde `n` é o número de elementos na fila de prioridade. Isso ocorre porque a propriedade do heap deve ser mantida após cada inserção ou remoção.

- **Complexidade de Espaço**:
    - A complexidade de espaço é **O(n)**, onde `n` é o número de elementos na fila de prioridade.

## Exemplos de Casos de Uso

- **Agendamento de tarefas**: Processamento de tarefas na ordem de sua prioridade.
- **Encontrar os k menores ou maiores elementos**: Usado em algoritmos que necessitam de ordenação ou seleção rápida.
- **Algoritmos de caminho mais curto**: Como o algoritmo de Dijkstra, que usa uma fila de prioridade para explorar os vértices de um grafo de maneira eficiente.

## Exemplo

Considerando a fila de prioridade (Min-Heap):

- Adicionando elementos: **15, 10, 20, 5**
- A ordenação dos elementos quando extraídos será: **5, 10, 15, 20**

A extração dos elementos em ordem crescente (de acordo com a prioridade) resultará em:

Min-Heap elements in ascending order: 5 10 15 20

Este exemplo ilustra como os elementos são extraídos da fila de prioridade em ordem crescente.

## Conclusão

A Fila de Prioridade (Min-Heap) é uma estrutura de dados útil em muitos problemas, incluindo o agendamento de tarefas, busca eficiente de elementos com prioridades específicas e a implementação de algoritmos que exigem manipulação de dados em ordem de prioridade. Sua implementação eficiente em Java com a classe `PriorityQueue` facilita a solução desses problemas de forma rápida e eficaz.

# Resolução do Problema da Mochila 0/1 usando Programação Dinâmica (Abordagem Bottom-Up)

## Descrição do Problema

Este problema resolve o clássico **Problema da Mochila 0/1** usando **Programação Dinâmica (Abordagem Bottom-Up)**. O Problema da Mochila 0/1 é um problema de otimização combinatória onde, dado um conjunto de itens, cada um com um peso e um valor, a tarefa é determinar a combinação mais valiosa de itens que pode ser colocada em uma mochila com capacidade limitada.

## Objetivo

O objetivo deste problema é encontrar a combinação de itens que maximize o valor total da mochila, sem exceder sua capacidade. A solução é encontrada usando programação dinâmica, abordando subproblemas menores e construindo a solução de forma iterativa.

## Definição do Problema

Dado:

- `n`: o número de itens.
- `W`: a capacidade da mochila.
- Uma lista de `n` itens, onde cada item tem:
    - `weight[i]`: o peso do item `i`.
    - `value[i]`: o valor do item `i`.

O objetivo é maximizar o valor total dos itens que podem ser colocados na mochila, sem que a soma dos pesos ultrapasse a capacidade da mochila.

## Abordagem de Programação Dinâmica (Bottom-Up)

Na abordagem bottom-up, construímos a solução resolvendo subproblemas menores primeiro. Usamos uma tabela 2D (`dp`), onde `dp[i][w]` representa o valor máximo que pode ser alcançado com os primeiros `i` itens e uma capacidade `w` da mochila.

A solução é construída de forma iterativa com a seguinte relação de recorrência:
- Se o peso do item atual é menor ou igual à capacidade atual `w`, podemos:
    1. Incluir o item na mochila e adicionar seu valor à melhor solução para a capacidade restante.
    2. Excluir o item e manter a solução do item anterior.
- Se o peso do item atual exceder a capacidade `w`, não podemos incluí-lo, então a solução será a mesma que a do item anterior.

### Caso Base
- Para capacidade 0 (w=0) ou sem itens (i=0), o valor máximo é 0.

### Passos

1. Criar um array 2D `dp[n+1][W+1]` para armazenar os valores máximos para cada combinação de itens e capacidades.
2. Iterar sobre todos os itens e capacidades, preenchendo a tabela `dp` usando a relação de recorrência.
3. A solução estará em `dp[n][W]`, que representa o valor máximo alcançável com `n` itens e capacidade da mochila `W`.

## Complexidade

- **Complexidade de Tempo**:
    - A complexidade de tempo é **O(n * W)**, onde `n` é o número de itens e `W` é a capacidade da mochila. Isso ocorre porque preenchemos a tabela `dp` de tamanho `(n+1) x (W+1)` em um loop aninhado.

- **Complexidade de Espaço**:
    - A complexidade de espaço é **O(n * W)** devido ao array 2D `dp` usado para armazenar as soluções dos subproblemas.

## Exemplo

Considerando os seguintes itens e capacidade da mochila:

- Itens:
    - Item 1: peso = 2, valor = 3
    - Item 2: peso = 3, valor = 4
    - Item 3: peso = 4, valor = 5
- Capacidade da mochila = 5

A solução ótima é pegar os itens 1 e 2, resultando em um valor máximo de **7**.

### Tabela `dp` para este exemplo:

| Itens \ Capacidade | 0  | 1  | 2  | 3  | 4  | 5  |
|-------------------|----|----|----|----|----|----|
| **0 itens**       | 0  | 0  | 0  | 0  | 0  | 0  |
| **Item 1**        | 0  | 0  | 3  | 3  | 3  | 3  |
| **Item 2**        | 0  | 0  | 3  | 4  | 4  | 7  |
| **Item 3**        | 0  | 0  | 3  | 4  | 5  | 7  |

Neste caso, a solução é escolher os itens 1 e 2, que geram um valor total de **7**, e isso é armazenado na célula `dp[3][5]`.

## Conclusão

O **Problema da Mochila 0/1** é uma excelente aplicação de **Programação Dinâmica** que ajuda a resolver problemas de otimização combinatória de maneira eficiente. Usando a abordagem bottom-up, conseguimos construir a solução ótima sem precisar explorar todas as combinações possíveis, resultando em uma solução eficiente tanto em tempo quanto em espaço.

# Processamento de Logs

## Descrição do Problema

Neste problema, o objetivo é analisar um arquivo de log grande para identificar a mensagem de erro mais frequente. Logs tipicamente contêm diversos tipos de mensagens, e nossa tarefa é extrair as mensagens de erro e contar quantas vezes cada uma aparece. Precisamos processar o arquivo linha por linha para encontrar a mensagem de erro que aparece com maior frequência.

## Objetivo

O objetivo é identificar a mensagem de erro mais frequente em um arquivo de log. O sistema assume que as mensagens de erro são rotuladas com a palavra "ERROR:" no arquivo.

## Abordagem

A abordagem para resolver o problema é a seguinte:

1. **Leitura do Arquivo**: Ler o arquivo de log linha por linha.
2. **Identificação das Mensagens de Erro**: Identificar linhas que contêm mensagens de erro, ou seja, aquelas que contêm o termo "ERROR".
3. **Extração das Mensagens de Erro**: Extrair a mensagem de erro de cada linha, considerando que a mensagem vem após a palavra "ERROR:".
4. **Contagem das Mensagens**: Armazenar as mensagens de erro e contar o número de vezes que cada uma aparece.
5. **Identificação da Mensagem mais Frequente**: Após processar todas as linhas, determinar qual mensagem de erro apareceu mais vezes.

## Funcionalidade

- O sistema assume que as mensagens de erro são identificadas pela palavra "ERROR:" no arquivo de log.
- O arquivo de log é lido de forma eficiente para lidar com grandes volumes de dados, sem sobrecarregar a memória.
- A contagem das mensagens de erro é realizada usando um mapa (`HashMap`), onde a chave é a mensagem de erro e o valor é o número de ocorrências.
- Ao final, o sistema retorna a mensagem de erro que apareceu mais frequentemente.

## Requisitos

- O sistema deve ser eficiente em termos de memória e tempo para processar arquivos de log grandes.
- Deve ser capaz de contar as ocorrências de cada mensagem de erro.
- O sistema deve exibir a mensagem de erro mais frequente no arquivo de log.

## Exemplo

Considere um arquivo de log com o seguinte conteúdo:

INFO: Process started ERROR: Database connection failed ERROR: Null pointer exception INFO: Process completed ERROR: Database connection failed ERROR: Timeout error ERROR: Database connection failed


Após processar o arquivo, o sistema identificará que a mensagem de erro **"Database connection failed"** apareceu 3 vezes, sendo a mais frequente.

### Tabela de Contagem

| Mensagem de Erro                  | Contagem |
|-----------------------------------|----------|
| Database connection failed        | 3        |
| Null pointer exception            | 1        |
| Timeout error                     | 1        |

A mensagem **"Database connection failed"** é a mais frequente.

## Considerações de Desempenho

- **Complexidade de Tempo**: O tempo de execução é **O(n)**, onde `n` é o número de linhas no arquivo de log, já que cada linha é processada uma vez.
- **Complexidade de Espaço**: A complexidade de espaço é **O(m)**, onde `m` é o número de mensagens de erro distintas no arquivo de log, já que as mensagens são armazenadas em um mapa.

## Conclusão

Este problema ilustra uma abordagem eficiente para o processamento de grandes arquivos de log, identificando a mensagem de erro mais frequente. Ele utiliza estruturas de dados simples, como mapas (`HashMap`), para contar e armazenar as ocorrências das mensagens de erro.

# Maior Subsequência Comum (LCS)

## Descrição do Problema

Neste problema, o objetivo é encontrar a **Maior Subsequência Comum (LCS)** entre duas cadeias de caracteres fornecidas. O problema da LCS é um problema clássico em ciência da computação, utilizado em áreas como bioinformática, comparação de textos e sistemas de controle de versão.

## Objetivo

Dadas duas cadeias de caracteres, `X` e `Y`, a tarefa é encontrar o comprimento da maior subsequência que aparece em ambas as cadeias, na mesma ordem, mas não necessariamente consecutivamente.

## Definição de Subsequência

Uma subsequência é uma sequência que pode ser derivada de outra sequência, removendo alguns ou nenhum dos elementos, sem alterar a ordem dos elementos restantes.

## Abordagem de Programação Dinâmica

A chave para resolver o problema da LCS de maneira eficiente é usar **Programação Dinâmica (PD)**. Criamos uma tabela 2D `dp[i][j]`, onde `dp[i][j]` representa o comprimento da LCS dos primeiros `i` caracteres da cadeia `X` e dos primeiros `j` caracteres da cadeia `Y`.

A relação de recorrência para preencher a tabela de PD é a seguinte:

- Se `X[i-1] == Y[j-1]`, então `dp[i][j] = dp[i-1][j-1] + 1` (ou seja, a LCS inclui este caractere).
- Caso contrário, `dp[i][j] = max(dp[i-1][j], dp[i][j-1])` (ou seja, escolhemos o máximo ao excluir o caractere atual de qualquer uma das duas cadeias).

## Caso Base

- Quando uma das cadeias é vazia (ou seja, `i = 0` ou `j = 0`), a LCS é 0, porque uma cadeia vazia não tem subsequência comum com nenhuma cadeia.

## Passos

1. Criar uma tabela 2D de PD `dp[m+1][n+1]` para armazenar o comprimento da LCS de cada subproblema.
2. Iterar sobre ambas as cadeias, preenchendo a tabela de PD com base na relação de recorrência.
3. A solução estará em `dp[m][n]`, que representa o comprimento da LCS para as cadeias completas `X` e `Y`.

## Complexidade de Tempo

- A complexidade de tempo é **O(m * n)**, onde `m` e `n` são os comprimentos das duas cadeias. Isso ocorre porque precisamos preencher uma tabela 2D de tamanho `(m+1) x (n+1)` usando um loop aninhado.

## Complexidade de Espaço

- A complexidade de espaço é **O(m * n)** devido ao uso da tabela 2D de PD para armazenar as soluções dos subproblemas.

## Exemplo

Dadas as seguintes cadeias de caracteres:

- `X = "ABCBDAB"`
- `Y = "BDCABB"`

A LCS é **"BCAB"**, com um comprimento de **4**.

### Tabela de Contagem de Subsequência Comum

| Índice em `X` | Índice em `Y` | Subsequência Comum |
|----------------|----------------|--------------------|
| 1              | 2              | B                  |
| 2              | 4              | C                  |
| 3              | 5              | A                  |
| 4              | 6              | B                  |

Neste exemplo, a LCS é "BCAB" com comprimento 4.

## Considerações de Desempenho

- **Complexidade de Tempo**: O tempo de execução é **O(m * n)**, onde `m` e `n` são os comprimentos das duas cadeias de caracteres, devido ao preenchimento da tabela 2D de tamanho `(m+1) x (n+1)`.
- **Complexidade de Espaço**: A complexidade de espaço é **O(m * n)** devido ao uso da tabela 2D para armazenar as soluções dos subproblemas.

## Conclusão

Este problema utiliza Programação Dinâmica para resolver o problema clássico da Maior Subsequência Comum (LCS), um desafio comum em áreas de bioinformática e comparação de textos. A solução é eficiente em termos de tempo e espaço e é amplamente aplicável em diversas áreas da ciência da computação.

# Maior Substring sem Caracteres Repetidos

## Descrição do Problema

Neste problema, o objetivo é encontrar o comprimento da **maior substring** de uma cadeia de caracteres fornecida que não contenha caracteres repetidos.

## Objetivo

Dada uma cadeia de caracteres `s`, a tarefa é determinar o comprimento da maior substring que não contenha caracteres duplicados. A substring deve ser contígua, ou seja, os caracteres devem aparecer na ordem original e não pode haver caracteres repetidos dentro dessa substring.

## Abordagem de Janela Deslizante

A solução ótima utiliza uma abordagem de **janela deslizante** combinada com um conjunto (hash set) para rastrear eficientemente os caracteres na janela atual (subsequência) enquanto iteramos pela cadeia de caracteres.

A ideia é manter uma "janela" (um intervalo de índices) que contém uma substring sem caracteres repetidos. À medida que percorremos a cadeia de caracteres, expandimos a janela adicionando caracteres à direita. Se um caractere se repetir dentro da janela, contraímos a janela a partir da esquerda até que o caractere repetido seja removido. O comprimento da janela a cada passo nos dá o comprimento atual de uma substring sem caracteres repetidos.

## Passos

1. Inicialize um conjunto para rastrear os caracteres na janela atual.
2. Use dois ponteiros (`start` e `end`) para representar os limites esquerdo e direito da janela.
3. À medida que o ponteiro `end` percorre a cadeia de caracteres, se o caractere em `s[end]` não estiver no conjunto, adicione-o ao conjunto e atualize o comprimento máximo.
4. Se o caractere já estiver no conjunto, mova o ponteiro `start` para a posição à direita da última ocorrência do caractere, efetivamente contraindo a janela.
5. Retorne o comprimento máximo da substring encontrado durante esse processo.

## Complexidade de Tempo

- A complexidade de tempo é **O(n)**, onde `n` é o comprimento da cadeia de caracteres `s`.
    - Os ponteiros `start` e `end` percorrem a cadeia uma única vez, e cada caractere é adicionado e removido do conjunto no máximo uma vez.

## Complexidade de Espaço

- A complexidade de espaço é **O(k)**, onde `k` é o tamanho do conjunto de caracteres (tipicamente 256 para caracteres ASCII estendidos ou 128 para caracteres ASCII básicos).
    - No pior caso, o conjunto pode armazenar todos os caracteres únicos na cadeia, portanto, a complexidade de espaço é proporcional ao número de caracteres distintos na cadeia.

## Exemplo

Dada a cadeia:

- `s = "abcabcbb"`

A maior substring sem caracteres repetidos é **"abc"**, com um comprimento de **3**.

### Tabela de Janela Deslizante

| Índice em `s` | Substring Atual | Tamanho da Substring |
|----------------|-----------------|----------------------|
| 0              | a               | 1                    |
| 1              | ab              | 2                    |
| 2              | abc             | 3                    |
| 3              | b               | 3                    |
| 4              | bc              | 3                    |
| 5              | c               | 3                    |
| 6              | b               | 3                    |
| 7              | b               | 3                    |

Neste exemplo, a maior substring sem caracteres repetidos é **"abc"**, com um comprimento de **3**.

## Considerações de Desempenho

- **Complexidade de Tempo**: O tempo de execução é **O(n)**, onde `n` é o comprimento da cadeia de caracteres.
- **Complexidade de Espaço**: A complexidade de espaço é **O(k)** devido ao conjunto de caracteres.

## Conclusão

Este problema utiliza a técnica de Janela Deslizante para resolver eficientemente o problema da Maior Substring sem Caracteres Repetidos. A solução proposta é ótima em termos de tempo e espaço, sendo aplicável a cadeias de caracteres com diferentes tamanhos e conjuntos de caracteres.

# Rotação de uma Matriz 2D 90 Graus no Sentido Horário

## Descrição do Problema

Neste problema, o objetivo é rotacionar uma matriz quadrada dada em **90 graus no sentido horário**. A matriz quadrada é uma matriz com o mesmo número de linhas e colunas (n x n).

## Objetivo

Dada uma matriz 2D `matrix` de tamanho `n x n`, a tarefa é rotacionar a matriz de forma que seus elementos sejam deslocados 90 graus no sentido horário. Isso significa que:

- O elemento na primeira linha e primeira coluna vai para a primeira coluna na última linha.
- O elemento na segunda linha e primeira coluna vai para a primeira coluna na penúltima linha.
- E assim por diante.

## Passos

A rotação de uma matriz 90 graus no sentido horário pode ser realizada em dois passos principais:

1. **Transpor a matriz**: Isso significa converter linhas em colunas. No passo de transposição, o elemento na posição `(i, j)` se torna o elemento na posição `(j, i)`.

2. **Reverter cada linha**: Após a transposição, inverta os elementos de cada linha para alcançar a rotação de 90 graus.

## Rotação no Lugar

A rotação é realizada no lugar, ou seja, sem usar espaço extra além da matriz original. Isso é feito transpondo a matriz e, em seguida, invertendo as linhas diretamente na matriz original.

## Complexidade de Tempo

- A complexidade de tempo deste algoritmo é **O(n^2)**, onde `n` é o número de linhas (ou colunas) na matriz. Isso ocorre porque tanto a transposição quanto a reversão das linhas exigem **O(n^2)** de tempo.

## Complexidade de Espaço

- A complexidade de espaço é **O(1)**, pois estamos realizando a operação no lugar, modificando a matriz diretamente sem usar espaço extra.

## Exemplo

Dada a matriz:

```java
matrix = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]
```

# Max Stack

## Problema: Max Stack

### Objetivo:
O objetivo deste problema é implementar uma pilha (Stack) com um recurso adicional que permite recuperar o valor máximo da pilha em tempo constante. A pilha deve ser capaz de suportar as seguintes operações:

- `push(x)`: Empilha o elemento `x` na pilha.
- `pop()`: Remove e retorna o topo da pilha.
- `top()`: Retorna o topo da pilha sem removê-lo.
- `getMax()`: Retorna o maior elemento da pilha em tempo constante O(1).

### Definição do Problema:
A tarefa é criar uma estrutura de dados `MaxStack` que comporte as operações tradicionais de pilha (`push`, `pop`, `top`) e, além disso, seja capaz de retornar o maior valor na pilha sem precisar percorrê-la toda. O desafio é garantir que a operação `getMax()` tenha complexidade O(1).

### Abordagem:

A solução para o problema utiliza duas pilhas:
1. **Pilha principal (`stack`)**: Onde os elementos são empilhados e desempilhados como uma pilha tradicional.
2. **Pilha auxiliar (`maxStack`)**: Onde armazenamos os valores máximos encontrados até o momento, de modo que o topo da pilha auxiliar sempre tenha o maior valor da pilha principal.

**Como funciona:**
- Ao empilhar um valor na pilha principal, também empilhamos o maior valor entre o novo valor e o topo da `maxStack` (garantindo que o topo de `maxStack` sempre contenha o maior valor da pilha).
- Ao remover um valor da pilha principal, removemos também da `maxStack` para manter a sincronia.
- A operação `getMax()` retorna o topo da `maxStack`, que sempre terá o maior valor da pilha principal.

### Complexidade de Tempo:

- **O(1)** para as operações `push()`, `pop()`, `top()`, e `getMax()`, pois todas essas operações são feitas de forma constante, apenas empilhando, desempilhando ou acessando os topos das pilhas.

### Complexidade de Espaço:

- **O(n)**, onde `n` é o número de elementos na pilha. A pilha auxiliar (`maxStack`) armazena no máximo o mesmo número de elementos da pilha principal.

### Exemplo:

```java
MaxStack maxStack = new MaxStack();
maxStack.push(5);
maxStack.push(1);
maxStack.push(10);
System.out.println(maxStack.getMax());  // Saída: 10
maxStack.pop();
System.out.println(maxStack.getMax());  // Saída: 5
```

# Maximum Subarray Sum (Kadane's Algorithm)

## Problema: Máxima Soma de Subarray Contíguo

### Descrição:
Dado um array de inteiros, o objetivo é encontrar o subarray contíguo (contendo pelo menos um número) que tenha a maior soma. A solução deve retornar a soma desse subarray.

**Exemplo:**
```plaintext
Entrada: [1, -2, 3, 4, -1, 2, 1, -5, 4]
Saída: 8
Explicação: O subarray contíguo com a maior soma é [3, 4, -1, 2, 1], que tem soma igual a 8.
```

# Most Frequent Element

## Problema: Elemento Mais Frequente

### Descrição:
O objetivo é encontrar o elemento que aparece com maior frequência em um dado array. Se houver múltiplos elementos com a mesma frequência máxima, deve-se retornar qualquer um deles.

**Exemplo:**
```plaintext
Entrada: [1, 3, 2, 3, 3, 1, 4]
Saída: 3
Explicação: O elemento mais frequente é 3, pois aparece 3 vezes no array.
```

# N-Queens Problem

## Descrição do Problema:

O problema das N-Rainhas é um clássico da ciência da computação e da inteligência artificial. O objetivo é colocar N rainhas em um tabuleiro de xadrez NxN de maneira que nenhuma rainha possa atacar outra. Ou seja, nenhuma rainha pode ser colocada na mesma linha, coluna ou diagonal que outra.

**Exemplo:**
Dado um tabuleiro 4x4, o algoritmo deve encontrar uma solução onde 4 rainhas sejam colocadas de maneira que não se ataquem.

```plaintext
Entrada: 4
Saída:
Q . . .
. . Q .
. Q . .
. . . Q
```

# Optimizing Nested Loops

## Descrição do Problema

O objetivo deste problema é otimizar um programa que utiliza loops aninhados para melhorar o desempenho. Loops aninhados podem gerar problemas de desempenho quando o tamanho de entrada cresce, pois a complexidade de tempo cresce exponencialmente. Uma abordagem comum para otimizar loops aninhados é eliminar cálculos desnecessários, reduzir o número de iterações ou utilizar um algoritmo mais eficiente.

Neste exemplo, comparamos uma implementação ingênua com loops aninhados (O(n²)) e, em seguida, refatoramos para obter um desempenho melhor com uma solução otimizada (O(n)).

**Problema:**
Dado um array de inteiros, queremos encontrar todos os pares que somam um valor alvo.

## Abordagem

### Visão Geral:
1. **Abordagem Ingênua (O(n²))**: Utiliza dois loops aninhados para verificar todos os pares no array.
2. **Abordagem Otimizada (O(n))**: Utiliza um conjunto (hash set) para armazenar os complementos dos números e verificar a soma alvo de maneira eficiente.

### Passos:
1. **Abordagem Ingênua (O(n²))**:
    - A função `findPairsNaive` usa dois loops aninhados para iterar sobre o array e verificar todos os pares possíveis.
    - Para cada elemento `i`, itera-se sobre os elementos `j` restantes e verifica-se se a soma `arr[i] + arr[j]` é igual ao valor alvo.

2. **Abordagem Otimizada (O(n))**:
    - A função `findPairsOptimized` utiliza um hash set para rastrear os elementos que já foram encontrados.
    - Para cada número `num` no array, calcula-se o complemento (`target - num`) e verifica-se se o complemento já está presente no conjunto.
    - Se o complemento for encontrado, significa que existe um par que soma o valor alvo e esse par é impresso.

### Complexidade:
- **Tempo**: A complexidade de tempo é **O(n²)** para a abordagem ingênua devido aos dois loops aninhados, e **O(n)** para a abordagem otimizada, que percorre o array uma vez e utiliza buscas em tempo constante com o hash set.

- **Espaço**: A complexidade de espaço é **O(n)** devido ao armazenamento dos elementos no hash set na abordagem otimizada.

### Exemplo de Execução:

Dado o array `arr = {2, 4, 3, 5, 7, 8, 9}` e o valor alvo `10`, o algoritmo encontra os pares que somam o valor alvo:

1. **Abordagem Ingênua**: O programa verifica todas as combinações possíveis de pares com dois loops aninhados.
2. **Abordagem Otimizada**: O programa usa um hash set para verificar rapidamente os complementos dos números.

**Saída**:

```plaintext
Abordagem Ingênua (O(n²)):
Par encontrado: (2, 8)
Par encontrado: (3, 7)
Par encontrado: (5, 5)

Abordagem Otimizada (O(n)):
Par encontrado: (2, 8)
Par encontrado: (3, 7)
Par encontrado: (5, 5)

Tempo de Execução da Abordagem Ingênua: [tempo em nanosegundos]
Tempo de Execução da Abordagem Otimizada: [tempo em nanosegundos]
```

# Parking Lot System

## Descrição do Problema

O objetivo deste problema é projetar e implementar um sistema de estacionamento com um número limitado de vagas. O sistema deve permitir que os carros estacionem e saiam, além de fornecer informações sobre as vagas disponíveis.

### Funcionalidades:

1. **park(carId)**: Estaciona um carro na primeira vaga disponível.
2. **leave(carId)**: Remove o carro com o dado `carId` do estacionamento.
3. **getAvailableSpaces()**: Retorna o número de vagas disponíveis.
4. **isFull()**: Verifica se o estacionamento está cheio.
5. **isEmpty()**: Verifica se o estacionamento está vazio.

### Abordagem:

- O estacionamento é modelado usando um array ou lista para representar as vagas de estacionamento.
- Cada elemento no array corresponde a uma vaga, que pode estar vazia (null) ou ocupada por um carro (representado por um `carId` único).
- O estacionamento tem uma capacidade fixa e o sistema precisa rastrear o número atual de carros estacionados.
- Quando um carro estaciona, ele é alocado na primeira vaga disponível. Quando um carro sai, a vaga que ele ocupava é liberada.

### Complexidade:
- **Espaço**: A complexidade espacial é **O(n)**, onde `n` é o número de vagas de estacionamento. Isso ocorre porque precisamos de um array ou lista de tamanho `n` para representar o estacionamento.
- **Tempo**:
    - A complexidade temporal para estacionar e retirar carros é **O(n)** no pior caso, pois podemos precisar iterar pelo estacionamento para encontrar a primeira vaga disponível ou ocupada.
    - As operações `getAvailableSpaces`, `isFull` e `isEmpty` podem ser realizadas em tempo constante **O(1)**.

## Exemplo:

Considerando um estacionamento com 3 vagas:

```java
ParkingLot parkingLot = new ParkingLot(3);
parkingLot.park(1); // Estaciona o carro com ID 1 na primeira vaga.
parkingLot.park(2); // Estaciona o carro com ID 2 na segunda vaga.
parkingLot.getAvailableSpaces(); // Retorna 1 (1 vaga disponível).
parkingLot.park(3); // Estaciona o carro com ID 3 na última vaga.
parkingLot.isFull(); // Retorna true (Estacionamento está cheio).
parkingLot.leave(1); // O carro com ID 1 sai do estacionamento.
parkingLot.getAvailableSpaces(); // Retorna 2 (2 vagas disponíveis).
parkingLot.isFull(); // Retorna false (Estacionamento não está cheio).
parkingLot.isEmpty(); // Retorna false (Estacionamento não está vazio).
```

# Payment Gateway System

## Descrição do Problema

O objetivo deste problema é projetar e implementar um sistema de gateway de pagamento que processa transações entre usuários de maneira simples. O sistema deve verificar se o remetente tem fundos suficientes, processar o pagamento, atualizar os saldos dos usuários e garantir segurança no processo de transação.

### Funcionalidades:

1. **processPayment(sender, receiver, amount)**: Processa um pagamento de um usuário para outro.
2. **getBalance(user)**: Retorna o saldo de um usuário.
3. **Verificação de fundos**: O sistema verifica se o remetente tem fundos suficientes antes de processar a transação.

### Abordagem:

- O sistema é modelado usando um `Map` para armazenar contas de usuários e seus saldos.
- O sistema verifica se o remetente e o receptor existem e se o remetente tem saldo suficiente antes de processar o pagamento.
- Após o pagamento, o saldo do remetente é reduzido e o saldo do receptor é aumentado.
- O sistema permite a consulta de saldo de qualquer usuário.

### Complexidade:
- **Espaço**: A complexidade espacial é **O(n)**, onde `n` é o número de contas de usuários armazenadas no `Map`.
- **Tempo**:
    - A complexidade temporal para processar o pagamento é **O(1)**, pois o acesso ao `Map` e as operações de atualização de saldo são feitas em tempo constante.
    - A complexidade para consultar o saldo de um usuário também é **O(1)**.

## Exemplo:

```java
PaymentGateway paymentGateway = new PaymentGateway();

// Processa um pagamento de user1 para user2
paymentGateway.processPayment("user1", "user2", 200.0);

// Verifica os saldos após a transação
System.out.println("User1 balance: $" + paymentGateway.getBalance("user1"));
System.out.println("User2 balance: $" + paymentGateway.getBalance("user2"));
```

# Producer-Consumer Problem

## Descrição do Problema

O **problema do Produtor-Consumidor** é um problema clássico de sincronização que envolve dois tipos de threads:
- **Produtores**: Geram dados e os adicionam a um buffer compartilhado (fila).
- **Consumidores**: Recuperam e processam os dados do buffer.

O problema garante que os produtores não adicionem dados ao buffer quando ele estiver cheio, e os consumidores não consumam dados quando o buffer estiver vazio.

## Abordagem

A solução para este problema utiliza uma fila (`Queue`) segura para threads, onde os dados produzidos por um produtor são armazenados até que um consumidor os consuma. A comunicação entre os produtores e consumidores é feita de forma sincronizada para evitar que dois ou mais threads manipulem o mesmo recurso simultaneamente, o que poderia causar inconsistências.

A sincronização é realizada utilizando as palavras-chave `synchronized` para garantir que apenas um thread por vez possa acessar a fila. Além disso, o método `wait()` é utilizado para fazer com que o produtor aguarde quando a fila estiver cheia e o consumidor aguarde quando a fila estiver vazia. Quando um item é produzido ou consumido, o método `notifyAll()` é chamado para notificar os outros threads sobre a mudança de estado (por exemplo, que um item foi adicionado ou removido da fila).

## Funcionalidades

- **Adicionar itens à fila (Produzir)**: Um produtor adiciona itens à fila, mas aguarda caso a fila esteja cheia. Quando um item é adicionado, o produtor notifica os consumidores de que um item está disponível para consumo.

- **Remover itens da fila (Consumir)**: Um consumidor retira itens da fila, mas aguarda caso a fila esteja vazia. Quando um item é retirado, o consumidor notifica os produtores de que há espaço na fila para novos itens.

## Como o Sistema Funciona

1. **Produtor**: A thread produtora gera um item e tenta colocá-lo na fila. Se a fila estiver cheia, ela espera até que haja espaço. Após adicionar o item à fila, a thread produtora notifica as threads consumidoras sobre a disponibilidade de um item.

2. **Consumidor**: A thread consumidora tenta retirar um item da fila. Se a fila estiver vazia, ela espera até que um item esteja disponível. Após consumir o item, a thread consumidora notifica as threads produtoras sobre a disponibilidade de espaço na fila.

## Características do Sistema

- **Concorrência**: O sistema permite que os produtores e consumidores operem de maneira concorrente sem conflito de dados.

- **Sincronização**: A sincronização é feita utilizando as palavras-chave `synchronized`, `wait` e `notifyAll` para garantir que os threads acessem a fila de maneira ordenada e sem violar as condições de concorrência.

- **Fila compartilhada**: A fila tem um tamanho máximo fixo e serve de buffer para os dados produzidos e consumidos.

## Requisitos

- O produtor só poderá produzir dados se a fila não estiver cheia.
- O consumidor só poderá consumir dados se a fila não estiver vazia.
- Ambos, produtor e consumidor, devem ser capazes de operar de maneira concorrente sem comprometer a integridade dos dados.

## Complexidade

- **Tempo**: As operações de produção e consumo têm uma complexidade de tempo **O(1)**, já que a inserção e remoção de elementos da fila são operações de tempo constante.

- **Espaço**: A complexidade de espaço é **O(N)**, onde `N` é o tamanho máximo da fila, pois a fila armazena os itens produzidos pelos produtores.

## Considerações de Sincronização e Segurança

A implementação utiliza mecanismos de **sincronização** para garantir que não haja condições de corrida entre os threads. O uso do método `wait()` faz com que as threads aguardem adequadamente quando a fila estiver cheia ou vazia, evitando que dados sejam corrompidos ou que as threads acessem a fila de maneira insegura.

Além disso, o uso de `notifyAll()` assegura que todos os threads (produtores ou consumidores) sejam notificados sempre que ocorrer uma mudança no estado da fila, permitindo que a execução continue de forma adequada e eficiente.

## Conclusão

O problema do Produtor-Consumidor é uma maneira eficaz de demonstrar como múltiplas threads podem compartilhar recursos de forma segura e coordenada. Usando as ferramentas de sincronização apropriadas, o sistema garante que os produtores e consumidores possam operar de maneira eficiente, sem corromper dados e sem bloquear a execução por períodos desnecessários.

# Rate Limiter

## Descrição do Problema

O algoritmo de **Rate Limiter** é projetado para prevenir o uso excessivo de APIs, limitando o número de requisições que um usuário pode fazer dentro de um determinado intervalo de tempo. Esse tipo de limitação é essencial para garantir a justiça no uso dos recursos, prevenir abusos e proteger o sistema subjacente de sobrecarga.

Neste problema, implementaremos um **rate limiter de janela fixa**, onde os usuários podem fazer um número determinado de requisições dentro de uma janela de tempo definida (por exemplo, 100 requisições por minuto). Após o intervalo de tempo expirar, a contagem de requisições é reiniciada.

## Abordagem

A solução utiliza um mapa (`Map`) para armazenar as informações de cada usuário, incluindo a quantidade de requisições feitas e o timestamp da última requisição. Para verificar se uma requisição pode ser feita, o sistema compara o timestamp atual com o timestamp da última requisição e verifica se o número de requisições dentro da janela de tempo permitida foi atingido.

### Passos do Algoritmo:

1. **Inicialização**: Quando um usuário faz sua primeira requisição, o sistema armazena o timestamp e o conta como a primeira requisição dentro de uma nova janela de tempo.

2. **Verificação de Requisição**:
    - Se o tempo atual exceder a janela de tempo definida desde a última requisição, o sistema reinicia a contagem e permite a nova requisição.
    - Se o número de requisições do usuário estiver dentro do limite da janela de tempo, a requisição é permitida e a contagem é incrementada.
    - Caso contrário, se o número máximo de requisições for excedido, a requisição é negada até que o tempo da janela seja renovado.

3. **Janela de Tempo**: A janela de tempo é renovada automaticamente após o intervalo de tempo especificado (por exemplo, 60 segundos).

## Requisitos

- O sistema deve ser capaz de verificar se um usuário está autorizado a realizar uma requisição a qualquer momento.
- O rate limiter deve rastrear o número de requisições feitas por cada usuário dentro da janela de tempo atual.
- Se um usuário ultrapassar o número permitido de requisições, as requisições subsequentes devem ser negadas até que a janela de tempo seja renovada.
- A janela de tempo deve ser redefinida automaticamente após o período especificado (exemplo: a cada 60 segundos).

## Como Funciona

1. **Primeira Requisição**: Quando um usuário realiza sua primeira requisição, o sistema armazena o timestamp da requisição e a contagem de requisições é iniciada.

2. **Novas Requisições**: Para cada requisição subsequente, o sistema verifica:
    - Se a janela de tempo expirou. Se sim, a contagem de requisições é reiniciada.
    - Se a quantidade de requisições feitas pelo usuário não ultrapassou o limite definido, a requisição é permitida e a contagem é incrementada.
    - Caso contrário, a requisição é negada.

3. **Excedendo o Limite**: Se o número de requisições de um usuário ultrapassar o máximo permitido, as requisições seguintes são negadas até que a janela de tempo se renove.

## Características do Sistema

- **Controle de Taxa**: O sistema permite um controle rígido sobre o número de requisições feitas por cada usuário, prevenindo sobrecarga no servidor.

- **Janela de Tempo Fixa**: A cada intervalo de tempo (por exemplo, 60 segundos), a contagem de requisições é reiniciada, garantindo que os usuários tenham uma oportunidade justa de fazer requisições.

- **Armazenamento de Informações de Requisição**: O sistema armazena dados específicos de cada usuário, como a última requisição feita e o número total de requisições dentro da janela de tempo.

## Complexidade

- **Tempo**: A operação de verificação e atualização de requisições tem complexidade **O(1)**, pois o sistema apenas acessa e atualiza o valor em um mapa de usuários.

- **Espaço**: A complexidade de espaço é **O(N)**, onde `N` é o número de usuários, pois o sistema armazena informações de cada usuário.

## Conclusão

O **Rate Limiter** é uma ferramenta fundamental para proteger APIs e sistemas backend contra abusos e garantir que o uso seja justo e eficiente. Este algoritmo de janela fixa é uma abordagem simples, mas eficaz, para garantir que os usuários não excedam o número de requisições permitidas dentro de um período de tempo determinado. Ao implementar esse sistema, é possível evitar sobrecarga do sistema e garantir que os recursos sejam distribuídos de forma equitativa.


# Recursion Factorial

## Descrição do Problema

O objetivo desse problema é calcular o fatorial de um número não negativo `n` utilizando recursão. O fatorial de um número `n`, denotado como `n!`, é o produto de todos os números inteiros positivos menores ou iguais a `n`. De forma mais específica, a função fatorial pode ser definida da seguinte maneira:

- `n! = n * (n-1) * (n-2) * ... * 1` para `n > 0`
- `0! = 1` (caso base)

## Definição do Problema

Dado um número inteiro não negativo `n`, precisamos calcular `n!` de forma recursiva. A função recursiva deve se chamar até atingir o caso base, onde `n == 0`.

### Caso Base:
- O fatorial de 0 é definido como 1. Este é o ponto de parada da recursão.

### Caso Recursivo:
- Para qualquer número positivo `n`, o fatorial de `n` é dado por `n * fatorial(n-1)`.

## Abordagem

A função fatorial pode ser implementada de forma recursiva da seguinte maneira:

1. No caso base, se `n == 0`, retornamos 1.
2. No caso recursivo, retornamos o produto de `n` e o fatorial de `n-1`.
3. A chamada recursiva continua até que o caso base seja atingido.

Este problema ilustra como utilizar a recursão para resolver problemas que podem ser quebrados em subproblemas menores.

## Complexidade

- **Complexidade de Tempo**: A complexidade de tempo é **O(n)**, onde `n` é o número de entrada. Isso ocorre porque a função realiza `n` chamadas recursivas, e cada uma delas realiza uma multiplicação constante de tempo.

- **Complexidade de Espaço**: A complexidade de espaço é **O(n)** devido à pilha de chamadas recursivas. No pior caso, a profundidade da recursão será igual a `n`, portanto, o espaço utilizado pela pilha de recursão é proporcional a `n`.

## Exemplo

Dado `n = 5`, o cálculo do fatorial é o seguinte:

- `fatorial(5) = 5 * fatorial(4)`
- `fatorial(4) = 4 * fatorial(3)`
- `fatorial(3) = 3 * fatorial(2)`
- `fatorial(2) = 2 * fatorial(1)`
- `fatorial(1) = 1 * fatorial(0)`
- `fatorial(0) = 1` (caso base)

Portanto, o fatorial de 5 é: `5 * 4 * 3 * 2 * 1 = 120`.

## Conclusão

O cálculo do fatorial utilizando recursão é um exemplo clássico de como problemas podem ser resolvidos de forma simples e eficiente com recursão. A abordagem recursiva divide o problema em subproblemas menores, resolvendo-os até atingir a solução final. No entanto, é importante ter cuidado com a profundidade da recursão, pois a complexidade de espaço pode crescer linearmente com o valor de `n`.


# Binary Search

## Descrição do Problema

O **Binary Search** (Busca Binária) é um algoritmo eficiente para encontrar o índice de um valor alvo em um **array ordenado**. Ao contrário da busca linear, que verifica cada elemento individualmente, a busca binária divide repetidamente o intervalo de busca pela metade, tornando o processo muito mais rápido.

## Objetivo

O objetivo é implementar e demonstrar o algoritmo de Busca Binária, que é utilizado para encontrar rapidamente a posição de um elemento em uma lista ordenada. A lista deve ser ordenada para que a busca binária funcione corretamente.

## Como Funciona a Busca Binária

A Busca Binária funciona comparando o valor do elemento alvo com o valor no meio do intervalo atual da pesquisa:

1. Se o valor do alvo for igual ao valor no meio, o índice do meio é retornado.
2. Se o valor do alvo for menor do que o valor no meio, a busca continua no lado esquerdo do array (metade inferior).
3. Se o valor do alvo for maior do que o valor no meio, a busca continua no lado direito do array (metade superior).

Esse processo é repetido até que o alvo seja encontrado ou o intervalo de pesquisa se torne inválido (quando `left > right`).

### Requisitos

- O array deve estar ordenado (em ordem crescente ou decrescente).
- A busca binária só funciona com arrays ordenados. Caso contrário, o algoritmo não será eficaz.

## Complexidade

- **Complexidade de Tempo**: **O(log n)**, onde `n` é o número de elementos no array. Isso ocorre porque a cada iteração o algoritmo reduz pela metade o intervalo de busca, tornando a busca muito eficiente.

- **Complexidade de Espaço**: **O(1)**, pois a busca binária requer apenas um número constante de variáveis adicionais, independentemente do tamanho do array.

## Abordagem

1. Inicialize dois índices: `left` para o primeiro índice do array e `right` para o último índice.
2. Em um loop, calcule o índice do meio como `mid = left + (right - left) / 2`.
3. Compare o elemento no índice `mid` com o alvo:
    - Se o elemento for igual ao alvo, retorne o índice `mid`.
    - Se o elemento for maior que o alvo, defina `right = mid - 1` para pesquisar na metade esquerda.
    - Se o elemento for menor que o alvo, defina `left = mid + 1` para pesquisar na metade direita.
4. Repita o processo até que o alvo seja encontrado ou o intervalo de pesquisa seja invalidado.

## Exemplo

Dado o array ordenado: `[1, 3, 5, 7, 8]` e um valor alvo `5`:

- Comece com `left = 0` e `right = 4`.
- Calcule `mid = (0 + 4) / 2 = 2`.
- O elemento no índice 2 é `5`, que é igual ao alvo.
- Retorne o índice 2 como resultado.

## Conclusão

A Busca Binária é uma técnica poderosa para procurar elementos em listas ordenadas, sendo muito mais eficiente do que a busca linear. Sua complexidade de tempo logarítmica faz dela uma excelente escolha quando lidamos com grandes volumes de dados ordenados.

# Merge Sort

## Descrição do Problema

O **Merge Sort** é um algoritmo de ordenação eficiente que segue o paradigma de **dividir e conquistar**. Ele divide recursivamente o array em duas metades, ordena cada metade e, em seguida, mescla as duas metades ordenadas em um único array ordenado.

## Objetivo

O objetivo é implementar o algoritmo Merge Sort, que é uma técnica de ordenação eficiente. A ideia central do Merge Sort é dividir o array em duas metades, ordenar cada metade recursivamente e, finalmente, combinar as metades ordenadas para produzir o array final ordenado.

## Como Funciona o Merge Sort

O Merge Sort funciona dividindo o array até que cada subarray tenha um único elemento. Em seguida, ele começa a mesclar esses subarrays de forma ordenada:

1. Divida o array em duas metades.
2. Ordene recursivamente cada metade.
3. Mescle as duas metades ordenadas em um array ordenado.

### Passos

1. **Divisão**: O array é recursivamente dividido em duas metades até que cada subarray tenha um único elemento.
2. **Ordenação**: Cada subarray é ordenado de forma recursiva (caso base: subarrays com um único elemento são triviais para ordenar).
3. **Mesclagem**: As metades ordenadas são mescladas, comparando seus elementos e inserindo-os na ordem correta.

### Requisitos

- O Merge Sort pode ser aplicado a qualquer tipo de dado que tenha uma relação de ordem (como números inteiros, strings, etc.).
- O algoritmo é eficiente para grandes volumes de dados devido à sua complexidade de tempo.

## Complexidade

- **Complexidade de Tempo**: **O(n log n)**, onde `n` é o número de elementos no array. A razão para a complexidade logarítmica é que o array é recursivamente dividido pela metade (`log n` divisões), e cada divisão requer a mesclagem de todos os `n` elementos.

- **Complexidade de Espaço**: **O(n)**, pois o Merge Sort precisa de espaço adicional para armazenar os subarrays temporários durante o processo de mesclagem.

## Abordagem

1. **Passo 1**: Dividir o array em duas metades.
2. **Passo 2**: Ordenar recursivamente cada metade.
3. **Passo 3**: Mesclar as metades ordenadas.

## Exemplo

Dado o array `[4, 3, 2, 1]`, o Merge Sort segue os seguintes passos:

1. **Passo 1**: Divida o array em duas metades: `[4, 3]` e `[2, 1]`.
2. **Passo 2**: Ordene recursivamente cada metade:
    - `[4, 3]` se torna `[3, 4]`.
    - `[2, 1]` se torna `[1, 2]`.
3. **Passo 3**: Mescle as metades ordenadas para obter `[1, 2, 3, 4]`.

## Conclusão

O Merge Sort é um algoritmo de ordenação eficiente com complexidade de tempo **O(n log n)**, o que o torna adequado para ordenações de grandes conjuntos de dados. Sua abordagem de dividir e conquistar é amplamente utilizada devido à sua eficiência e estabilidade.

# URL Shortener

## Descrição do Problema

Um **URL Shortener** é um sistema projetado para pegar uma URL longa e gerar uma URL curta e única que redireciona para a URL original. O objetivo é criar um sistema escalável que possa lidar com bilhões de solicitações de encurtamento de URLs e mapear essas URLs de volta para suas versões originais quando solicitadas.

## Objetivo

O objetivo é criar um serviço de encurtamento de URL que, dado uma URL longa, gere uma URL curta e, em seguida, seja capaz de redirecionar para a URL original quando solicitado. A implementação deve ser capaz de lidar com um grande volume de solicitações de encurtamento e recuperação de URLs.

## Como Funciona o URL Shortener

O processo básico para encurtar uma URL é:

1. **Gerar uma URL curta**: A URL longa é convertida em uma string curta e única que a representa. Uma abordagem comum é utilizar um código alfanumérico, que é gerado a partir do hash da URL longa.
2. **Armazenar a URL curta**: A URL curta é mapeada para a URL longa em um banco de dados ou sistema de armazenamento de chave-valor.
3. **Redirecionamento**: Quando uma URL curta é acessada, o sistema recupera a URL longa associada e redireciona o usuário para ela.

### Abordagem

- **Passo 1**: Gerar a URL curta com base na URL longa, utilizando um método simples de codificação, como a hash do código.
- **Passo 2**: Armazenar o mapeamento entre a URL curta e a URL longa em um sistema de armazenamento eficiente, como um banco de dados ou uma estrutura de dados como um `HashMap`.
- **Passo 3**: Quando a URL curta é acessada, recuperar a URL longa e redirecionar o usuário.

## Requisitos

- O sistema deve gerar URLs curtas únicas para cada URL longa.
- O sistema deve ser capaz de mapear a URL curta de volta para a URL longa.
- O sistema deve ser escalável para lidar com bilhões de solicitações de encurtamento e recuperação de URLs.

## Limitações

- Este exemplo é simplificado e usa uma abordagem baseada em hash para gerar URLs curtas. Em uma implementação real, pode ser necessário lidar com problemas como colisões de hash, persistência de dados e distribuir o sistema para alta disponibilidade.
- A solução simplificada não lida com funcionalidades como a prevenção de colisões entre URLs curtas geradas para diferentes URLs longas.

## Exemplo

Dada a URL longa:

`https://www.example.com/this-is-a-very-long-url`

A URL curta gerada pode ser:

`http://short.ly/abcdef`

Quando a URL curta é acessada, o sistema recupera a URL original associada e redireciona para `https://www.example.com/this-is-a-very-long-url`.


# Word Search

## Descrição do Problema

O problema envolve a busca de uma palavra em uma grade 2D de letras, onde a palavra pode ser formada ao se mover horizontalmente, verticalmente ou diagonalmente. O desafio é encontrar se uma palavra dada existe na grade, navegando por células adjacentes.

## Objetivo

O objetivo é determinar se uma palavra específica pode ser encontrada em uma grade 2D de caracteres. A palavra pode ser formada ao mover-se de uma célula para outra adjacente, e o movimento pode ocorrer em qualquer direção: para cima, para baixo, para a esquerda, para a direita, ou nas quatro diagonais.

## Como Funciona a Solução

A solução usa a abordagem de **Busca em Profundidade (DFS)** para explorar todas as direções possíveis a partir de cada célula na grade. A busca é realizada da seguinte maneira:

1. **Exploração Recursiva**: Para cada célula na grade, o algoritmo tenta combinar o primeiro caractere da palavra. Se corresponder, ele verifica recursivamente as células adjacentes (acima, abaixo, esquerda, direita e diagonais).
2. **Marcações Temporárias**: Para evitar visitar a mesma célula mais de uma vez, o algoritmo marca temporariamente as células como visitadas, alterando seu valor para um marcador (como `#`).
3. **Restauro de Células**: Após a exploração recursiva de cada célula, o valor original da célula é restaurado, permitindo que outras buscas possam passar por ela.
4. **Condicional de Término**: Se a palavra for encontrada durante a busca, o algoritmo retorna `true`. Caso contrário, após explorar todas as possibilidades, ele retorna `false`.

## Requisitos

- O algoritmo deve procurar eficientemente a palavra na grade, considerando todas as direções possíveis de movimento.
- Deve retornar `true` se a palavra existir, e `false` caso contrário.

## Complexidades

- **Complexidade de Tempo**: A complexidade de tempo é **O(M * N * 4^L)**, onde `M` é o número de linhas, `N` é o número de colunas e `L` é o comprimento da palavra a ser buscada. A busca explora todas as direções possíveis em cada célula, o que leva a um crescimento exponencial no número de chamadas recursivas à medida que o comprimento da palavra aumenta.

- **Complexidade de Espaço**: A complexidade de espaço é **O(L)** devido à pilha de recursão, onde `L` é o comprimento da palavra.

## Exemplo

Dada a grade 2D de caracteres:



