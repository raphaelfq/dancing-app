package com.example.dancingwikiapp.data

data class Verb(
    val name: String,
    val translation: String,
    val description: String,
    val modifiers: List<String>
)

data class Substantive(
    val name: String,
    val translation: String,
    val description: String,
    val modifiers: List<String>
)

val verbs = listOf(
    Verb(
        name = "Assemblé",
        translation = "Juntado",
        description = "Uma das pernas é lançada (jeté), a outra se flexiona (fondu), o bailarino salta (sauté) juntado as pernas no ar e volta ao chão com ambas juntas.",
        modifiers = listOf("pettit", "grand", "dessus", "dessous", "devant", "derrière", "en avant", "an arrièrre", "en tournant", "battu")
    ),
    Verb(
        name = "Balancé",
        translation = "Balançado",
        description = "Como uma valsa, o primeiro pé pisa para a lateral, o outro faz couppé atrás, couppé com o pé da frente e couppé com o pé de trás novamente, transferindo o peso de um pé para o outro.",
        modifiers = listOf("an avante", "an arrière")
    ),
    Verb(
        name = "Balloné",
        translation = "Pulando como uma bola",
        description = "Uma perna é lançada (jeté) e a outra se flexionam para preparar para o salto, o bailarino salta juntando a perna lançada em couppé/sur le cu-de-pied.",
        modifiers = listOf("grand", "sur le pointe", "devant", "a la seconde")
    ),
    Verb(
        name = "Balloté",
        translation = "Jogado, atirado",
        description = "As pernas saltam juntas, no ar é feito um passé developpé, a perna termina de se estender no developpé quando a outra volta ao chão em plié.",
        modifiers = listOf("en avant", "en arrière")
    ),
    Verb(
        name = "Brisé",
        translation = "Partido",
        description = "Uma das pernas é lançada, a outra realiza o salto. A perna de trabalho se junta na direção oposta que saiu e se fecha terminando o salto na mesma posição que se iniciou. Como em assemblé que realiza uma batida antes de finalizar na posição de início.",
        modifiers = listOf("dessous", "dessous", "en avant", "en arrière", "volé", "télémaque")
    ),
    Verb(
        name = "Changement",
        translation = "Trocado",
        description = "Salto em que os pés trocam de lugar no ar.",
        modifiers = listOf("battu")
    ),
    Verb(
        name = "Chassé",
        translation = "Caçado",
        description = "Salto: degagé, o outro pé toma o lugar do primeiro, que se desloca para a direção apontada inicialmente.\nArrastando: degagé, o pé se arrasta no chão até que o peso se transfira para ele, deixando o outro livre para fechar a posição.",
        modifiers = listOf("an avant", "an arrière", "de coté")
    ),
    Verb(
        name = "Coupé",
        translation = "Cortado",
        description = "Um pé em sur le cou-de-pied corta o outro tomando seu lugar ao chão, o pé que estava no chão é lançado para o próximo movimento, preparação para outro passo.",
        modifiers = listOf("dessus", "dessous")
    ),
    Verb(
        name = "Couru",
        translation = "Corrido",
        description = "Os pés deslizam rapidamente pelo chão em meia ponta ou ponta.",
        modifiers = listOf()
    ),
    Verb(
        name = "Degagé",
        translation = "Destacado",
        description = "Como um tendu com fondu, usado principalmente em preparações.",
        modifiers = listOf("devant", "derrière", "a la seconde")
    ),
    Verb(
        name = "Detiré",
        translation = "Destender",
        description = "Alongamento sustentando a perna esticada com a mão correspondente.",
        modifiers = listOf("devant", "derrière", "à la seconde")
    ),
    Verb(
        name = "Detourné",
        translation = "Desvirado",
        description = "Uma volta em meia ponta ou ponta na direção da perna de trás, invertendo os pés.",
        modifiers = listOf("demi")
    ),
    Verb(
        name = "Developpé",
        translation = "Desenvolvido",
        description = "Uma perna desliza sobre a outra subindo para um passé, depois se estende no ar (en l'air).",
        modifiers = listOf("devant", "derrière", "à la seconde", "effacé", "écarte", "croisé", "en arabesque", "en attitude")
    ),
    Verb(
        name = "Echappé",
        translation = "Escorregado, escapado",
        description = "Os pés de deslocam de uma posição (1°, 3° ou 5°) para outra (2° ou 4°), escorregando ou pulando (echappé sauté).",
        modifiers = listOf("sauté", "grand", "sur le pointe", "battu", "royal")
    ),
    Verb(
        name = "Emboité",
        translation = "Encaixado",
        description = "Nome usado para diversos passos a depender do método utilizado.",
        modifiers = listOf()
    ),
    Verb(
        name = "Entrechat",
        translation = "Entrelaçado",
        description = "Salto em que as pernas trocam de lugar no ar e voltam ao chão na organização inicial, pode-se realizar múltiplas trocas.",
        modifiers = listOf("volé", "double", "triple")
    ),
    Verb(
        name = "Enveloppé",
        translation = "Envolvido",
        description = "A perna sai esticada e retorna à posição inicial passando pelo passé. O contrário de developpé.",
        modifiers = listOf("sauté")
    ),
    Verb(
        name = "Failli",
        translation = "Falho",
        description = "Salto em que as duas pernas saem do chão juntas, fazem uma pequena curva para trás e a perna de trás faz um arabesque (enquanto ainda no ar).",
        modifiers = emptyList<String>()
    ),
    Verb(
        name = "Fouetté",
        translation = "Chicoteado",
        description = "Nome usado para diversos passos a depender do método utilizado.\n" +
                "Giro: uma das pernas faz passé, developpé devant (a outra faz fondu), demi rond jambé en l'air (a outra perna faz relevé) e volta para o passé girando, a perna funciona como um chicote impulsionando o giro.\n" +
                "Fouetté italiano: uma das pernas faz um grand battement à la seconde, faz um chicote passando pelo chão em plié e virando o corpo, terminando em attitude derrière.\n" +
                "Salto ou relevé: a perna é lançada num grand battement devant e o corpo se vira tornando a perna num arabesque.",
        modifiers = emptyList<String>()
    ),
    Verb(
        name = "Glissade",
        translation = "Deslizamento",
        description = "Um dos pés é lançado saindo do chão, num pequeno salto ambas as pernas saem do chão rapidamente, a segunda perna desliza de volta para a posição inicial.",
        modifiers = listOf("devant", "derrière", "dessous", "dessus", "an avant", "an arrière", "sur le pointe")
    ),
    Verb(
        name = "Glissé",
        translation = "Escorregado",
        description = "O pé escorrega até se descolar do chão e escorrega de volta para a posição inicial.",
        modifiers = listOf("devant", "derrière", "à la seconde")
    ),
    Verb(
        name = "Jeté",
        translation = "Jogado, lançado",
        description = "Um pé é lançado durante o salto, o outro finaliza o salto em sur le cou-de-pied.",
        modifiers = listOf("derrière", "devant", "à la seconde", "an avant", "en arrière", "pettit", "grand", "en tournant", "battu", "enveloppé")
    ),
    Verb(
        name = "Marché",
        translation = "Marcha",
        description = "Caminhada característica do balé, os dedos encostam no chão antes dos calcanhares.",
        modifiers = emptyList<String>()
    ),
    Verb(
        name = "Piqué",
        translation = "Mergulhou",
        description = "A ponta do pé direciona a direção em que o peso se deslocará, subindo na meia-ponta ou na ponta, precisa de modificador.",
        modifiers = listOf("en avant", "en arrière", "en arabesque", "en tournant", "passé", "en dehors", "en dedans")
    ),
    Verb(
        name = "Pirouette",
        translation = "Rodopiar",
        description = "Giro completo em meia ponta ou ponta.",
        modifiers = listOf("en dedans", "en dehors", "simples", "dupla", "en attitude", "en arabesque", "sur le cou-de-pied", "passé", "à la seconde", "renverse", "grand")
    ),
    Verb(
        name = "Plié",
        translation = "Flexionado",
        description = "Os dois joelhos se flexionam e se estendem simultaneamente.",
        modifiers = listOf("demi", "grand")
    ),
    Verb(
        name = "Promenade",
        translation = "Em passeio",
        description = "Um giro vagaroso em torno de si mantendo a posição anterior, normalmente um attitude ou arabesque.",
        modifiers = listOf("en arabesque", "en attitude", "en dehors", "en dedans")
    ),
    Verb(
        name = "Temps lié",
        translation = "Passo unido",
        description = "Tendu, demi plié transferindo o peso para as duas pernas (em 2º ou 4º posição), tendu para a segunda perna, fermé.",
        modifiers = emptyList<String>()
    ),
    Verb(
        name = "Temps levé",
        translation = "Tempo elevado",
        description = "Salto que parte e retorna de uma perna só.",
        modifiers = listOf("passé", "en arabesque", "developpé", "sur le cou-de-pied")
    ),
    Verb(
        name = "Tendu",
        translation = "Esticado",
        description = "O pé desliza esticado pelo chão até alcançar sua extensão máxima sem se descolar do chão.",
        modifiers = listOf("devant", "derrière", "à la seconde")
    ),
    Verb(
        name = "Tombé",
        translation = "Cair",
        description = "Um passo em que todo o peso é transferido.",
        modifiers = listOf("an avant", "à la seconde")
    )
)


val substantives = listOf(
    Substantive(
        name = "Arabesque",
        translation = "Arabesco",
        description = "O corpo se apoia apenas em uma perna, a outra está estendida atrás no ar.",
        modifiers = listOf("allongé", "croisée", "à terre", "penchée", "en tournant", "fondu", "en promenade")
    ),
    Substantive(
        name = "Attitude",
        translation = "Atitude",
        description = "O corpo se apoia apenas em uma perna, a outra está no ar e flexionada.",
        modifiers = listOf("croisée", "effacée", "en face", "ouverte", "en tournant en promenade", "devant", "derrière", "a la seconde")
    ),
    Substantive(
        name = "Battement",
        translation = "Batimento",
        description = "Aparece sempre acompanhado de um modificador, uma perna de destaca.",
        modifiers = listOf("Grand battement", "Grand battement jeté", "Battement frappé", "Battement tendu", "Battement fondu", "Battement glissé", "Battement serré", "Battement jeté")
    ),
    Substantive(
        name = "Bras bas",
        translation = "Braços baixos",
        description = "Os braços desenham um círculo baixo, próximo às coxas.",
        modifiers = listOf()
    ),
    Substantive(
        name = "Cabriole",
        translation = "Salto de cabra, cabriola",
        description = "Uma perna é lançada no ar estendida, a outra a encontra num salto fazendo uma ou mais batidas e retorna ao chão, a primeira perna permanece no ar.",
        modifiers = listOf("devant", "derrière", "a la seconde", "ouverte", "battu")
    ),
    Substantive(
        name = "Chainé",
        translation = "Cadeias, élos",
        description = "Uma série de giros em meia-ponta ou ponta com os joelhos estendidos.",
        modifiers = listOf()
    ),
    Substantive(
        name = "Ciseaux",
        translation = "Tesoura",
        description = "Durante o salto uma das pernas é lançada à frente e troca bruscamente para a trás, abrindo ambas as pernas como num grand jeté.",
        modifiers = listOf()
    ),
    Substantive(
        name = "Contretemps",
        translation = "Contratempo",
        description = "Partindo da 4º posição, a perna faz uma rotação de trás para frente próxima ao chão (rond jambé en dedans en l'air) e troca de lugar pulando com a perna de base que se estende a frente.",
        modifiers = listOf()
    ),
    Substantive(
        name = "Déboulés",
        translation = "Rolando como uma bola",
        description = "Giro em meia-ponta ou ponta com os joelhos esticados.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Flic-flac",
        translation = "Onomatopeia referente à imagem do movimento",
        description = "Giro em que a perna faz um couppé para realizar metade do giro e mais um couppé para finalizá-lo.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Gargoulliade",
        translation = "Borborinho, som do borbulhar",
        description = "Pas de chat com rond jambé nas duas pernas durante o salto.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Pas de basque",
        translation = "Passo de Basque (das danças nacionais dos bascos)",
        description = "Rond jambé à terre en dehors seguido por um chassé arrastando pelo chão.",
        modifiers = listOf("sauté")
    ),
    Substantive(
        name = "Pas de bourré",
        translation = "Tipo musical bourré",
        description = "Preparação em sur le-cou-de-pied ou degagé, os pés se juntam em sous-sous, se separam em 2º posição ainda em meia-ponta ou ponta, e finalizam juntando os dois pés no chão, todas as etapas deslocam para a mesma direção.",
        modifiers = listOf("dessous", "dessus", "devant", "derrière", "en avant", "en arrière", "en tournant en dedans", "en tournant en dehors", "sur le pointe", "sur le cou-de-pied", "passé")
    ),
    Substantive(
        name = "Pas de chat",
        translation = "Passo do gato",
        description = "Salto em que as pernas, uma de cada vez, realizam o passé se deslocando lateralmente.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Pas de cheval",
        translation = "Passo do cavalo",
        description = "A perna passa pelo sur le cou-de-pied e faz um pequeno developpé se estendendo.",
        modifiers = listOf("devant", "derrière", "à la seconde")
    ),
    Substantive(
        name = "Pas de valse",
        translation = "Passo da valsa, do tempo musical valsa",
        description = "Um pé realiza passo, o outro pé cruza atrás deste e o peso é levemente transferido para o que está trás, criando um balanço.",
        modifiers = listOf("en tournant", "an avant", "an arrière")
    ),
    Substantive(
        name = "Port de bras",
        translation = "Porte de braços",
        description = "Sequência em que se realizam movimentos dos braços, passando pelas posições básicas.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Reverence",
        translation = "Reverência",
        description = "Um pé realiza um passo para a lateral, o outro pé cruza atrás deste, os joelhos se dobram e o corpo se inclina para a frente.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Rond jambe",
        translation = "Roda de perna",
        description = "Toda a perna faz um círculo utilizando a articulação coxofemoral.",
        modifiers = listOf("à terre", "en l'air", "en dehors", "en dedans", "relevé", "grand", "sauté", "demi", "balancé")
    ),
    Substantive(
        name = "Royale",
        translation = "Real",
        description = "Changement, mas, antes de os pés trocarem de posição, as coxas se juntam mais.",
        modifiers = listOf("double")
    ),
    Substantive(
        name = "Saut cheval",
        translation = "Salto do cavalo",
        description = "Grande salto em que uma perna faz passe e developpé devant e a outra grand battement derrière.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Sissone",
        translation = "Nome do inventor do passo",
        description = "Salto em que as duas pernas saem do chão ao mesmo tempo, mas uma volta ao chão antes que a outra.",
        modifiers = listOf("devant", "derrière", "passé", "en tournant", "ouverte", "en avant", "en arrière", "double", "dessous", "dessus", "fondu", "battu")
    ),
    Substantive(
        name = "Soubresaut",
        translation = "Solavanco",
        description = "Salto com as pernas juntas.",
        modifiers = listOf("devant", "derrière", "passé", "en tournant", "ouverte", "en avant", "en arrière", "double", "dessous", "dessus", "fondu", "battu")
    ),
    Substantive(
        name = "Sous-sous / sous-sus / sus-sous",
        translation = "Debaixo, abaixo",
        description = "Relevé um 5º posição com as pernas e pés bem juntos.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Sur le cou-de-pied",
        translation = "Sobre o pescoço do pé",
        description = "O pé se apoia no tornozelo da outra perna na altura dos maléolos.",
        modifiers = listOf("devant", "derrière")
    ),
    Substantive(
        name = "Temps de cuisse",
        translation = "Passo de coxa",
        description = "Uma das pernas troca a posição passando pelo couppé, depois é feito um sissone.",
        modifiers = listOf("dessus", "dessous")
    ),
    Substantive(
        name = "Temps de flèche",
        translation = "Passo de flecha",
        description = "Uma das pernas faz um passé e, na volta, salta lançando a outra num grand battement.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Temps de l'ange",
        translation = "Passo de anjo",
        description = "Salto em que as duas pernas se juntam atrás em attitude, fazendo uma curva para trás junto com a coluna.",
        modifiers = emptyList<String>()
    ),
    Substantive(
        name = "Temps de poisson",
        translation = "Passo de peixe",
        description = "Salto em que as duas pernas se juntam esticadas, fazendo uma curva para trás junto com a coluna.",
        modifiers = emptyList<String>()
    ))
