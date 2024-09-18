package com.example.dancingwikiapp


data class Position(
    val id: Int,
    val name_official: String,
    val synonyms: List<String>,
    val description: String,
    val grade: Int,
    val complexity: Int,
    val typo: String,
    val translation: String,
    val detailed_description: String,
    val related: List<String>,
    val methodical_description: String,
    val child_explanation: String
) : Searchable {

    override fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(name_official, "${name_official.first()}") + synonyms
        return matchingCombinations.any { it.contains(query, ignoreCase = true) }
    }
}




//Define some nomination rules for the Positions
val Positions = listOf(
    Position(
        id = 1,
        name_official = "Primeira Posição",
        synonyms = listOf("Pés em V", "Pés juntinhos", "Pés de porta"),
        description = "Posição inicial do balé clássico, com os pés juntos em forma de V, joelhos retos e tornozelos flexíveis.",
        grade = 1,
        complexity = 1,
        typo = "Première Position",
        translation = "Primeira Posição",
        detailed_description = "A primeira posição é a base de todas as outras posições do balé clássico. Ela ajuda a desenvolver o alinhamento, o equilíbrio e a força dos pés e tornozelos. Os pés devem estar unidos com as pontas voltadas para fora, formando um ângulo de 45 graus. Os joelhos devem estar retos e os tornozelos flexíveis.",
        related = listOf("Alinhamento", "Equilíbrio", "Força dos pés", "Flexibilidade dos tornozelos"),
        methodical_description = "Para assumir a primeira posição, comece com os pés juntos.  Em seguida, gire os pés para fora, formando um ângulo de 45 graus. Mantenha os joelhos retos e os tornozelos flexíveis.",
        child_explanation = "Imagine que seus pés são como as pernas de uma bailarina de brinquedo. Você coloca as pernas juntas e depois as gira um pouquinho para fora, como se estivesse fazendo um 'V' com as pernas. "
    ),
    Position(
        id = 2,
        name_official = "Segunda Posição",
        synonyms = listOf("Pés afastados", "Pés abertos", "Pés de linha reta"),
        description = "Os pés estão afastados na largura dos ombros, em linha reta, com joelhos retos e tornozelos flexíveis.",
        grade = 1,
        complexity = 1,
        typo = "Seconde Position",
        translation = "Segunda Posição",
        detailed_description = "Na segunda posição, os pés são afastados na largura dos ombros, em linha reta. Os joelhos devem permanecer retos e os tornozelos flexíveis. A segunda posição é fundamental para desenvolver a força e a flexibilidade das pernas, além de auxiliar na criação de amplitude de movimento.",
        related = listOf("Força das pernas", "Flexibilidade das pernas", "Amplitude de movimento"),
        methodical_description = "Comece na primeira posição. Em seguida, mova uma perna para o lado, mantendo o pé em pointe e a linha reta do corpo. Certifique-se de que seus pés estejam afastados na largura dos seus ombros.",
        child_explanation = "Na segunda posição, você abre as pernas como se estivesse colocando os pés na linha de partida para uma corrida. Seus pés devem ficar bem afastados, como a largura dos seus ombros. "
    ),
    Position(
        id = 3,
        name_official = "Terceira Posição",
        synonyms = listOf("Pés cruzados", "Meia quinta", "Posição intermediária"),
        description = "Um pé está à frente do outro, com o calcanhar do pé da frente junto ao arco do pé de trás, tornozelos flexíveis.",
        grade = 1,
        complexity = 2,
        typo = "Troisième Position",
        translation = "Terceira Posição",
        detailed_description = "A terceira posição é uma posição intermediária entre a primeira e a quinta posição. É uma preparação para a quinta posição e ajuda a desenvolver o equilíbrio, a força e a flexibilidade. Um pé está à frente do outro, com o calcanhar do pé da frente junto ao arco do pé de trás. Os joelhos devem estar retos e os tornozelos flexíveis.",
        related = listOf("Equilíbrio", "Força", "Flexibilidade", "Preparação para a quinta posição"),
        methodical_description = "Comece na primeira posição. Em seguida, mova um pé para frente, encaixando o calcanhar junto ao arco do outro pé.  Mantenha a linha reta do corpo e os tornozelos flexíveis.",
        child_explanation = "Na terceira posição, você coloca um pé na frente do outro, com o calcanhar do pé da frente encostando no outro pé. É como se você estivesse fazendo um pequeno passo para frente com um pé."
    ),
    Position(
        id = 4,
        name_official = "Quarta Posição",
        synonyms = listOf("Um pé à frente", "Posição avançada", "Pés separados"),
        description = "Um pé está à frente do outro, com os pés separados na largura de um pé, joelhos retos e tornozelos flexíveis.",
        grade = 1,
        complexity = 2,
        typo = "Quatrième Position",
        translation = "Quarta Posição",
        detailed_description = "Na quarta posição, um pé está à frente do outro, com os pés separados na largura de um pé. Os joelhos devem estar retos e os tornozelos flexíveis.  A quarta posição é importante para desenvolver o equilíbrio, a força e a coordenação entre as pernas.",
        related = listOf("Equilíbrio", "Força", "Coordenação", "Movimento"),
        methodical_description = "Comece na terceira posição. Em seguida, mova o pé da frente para frente até que os pés estejam separados na largura de um pé. Mantenha a linha reta do corpo e os tornozelos flexíveis.",
        child_explanation = "Na quarta posição, você coloca um pé na frente do outro, com os pés um pouco mais separados do que na terceira posição. É como se você estivesse dando um passo maior para frente com um pé."
    ),
    Position(
        id = 5,
        name_official = "Quinta Posição",
        synonyms = listOf("Pés fechados", "Pés encaixados", "Cruz total"),
        description = "Um pé está à frente do outro, com o calcanhar do pé da frente tocando a ponta do pé de trás, tornozelos flexíveis.",
        grade = 1,
        complexity = 3,
        typo = "Cinquième Position",
        translation = "Quinta Posição",
        detailed_description = "A quinta posição é a posição mais fechada do balé clássico. Ela exige grande flexibilidade, força e equilíbrio. Um pé está à frente do outro, com o calcanhar do pé da frente tocando a ponta do pé de trás. Os joelhos devem estar retos e os tornozelos flexíveis.",
        related = listOf("Flexibilidade", "Força", "Equilíbrio", "Movimento"),
        methodical_description = "Comece na quarta posição.  Em seguida, mova o pé da frente para frente, encaixando o calcanhar junto à ponta do outro pé. Mantenha os tornozelos flexíveis e a linha reta do corpo.",
        child_explanation = "Na quinta posição, você coloca um pé na frente do outro, com o calcanhar do pé da frente bem encostado na ponta do outro pé. É como se você estivesse cruzando os pés completamente."
    )
)