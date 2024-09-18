package com.example.dancingwikiapp


data class Movement(
    val name_official: String,
    val synonyms: List<String>,
    val description: String,
    val grade: Int,
    val complexity: Int,
    val typo: String
) : Searchable {

    override fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombinations = listOf(name_official, typo, "${name_official.first()}") + synonyms
        return matchingCombinations.any { it.contains(query, ignoreCase = true) }
    }
}




//Define some nomination rules for the Positions



// Movimentos até a Grade 3 com a nova variável typo
val Movements = listOf(
    Movement(
        name_official = "Plié",
        synonyms = listOf("Dobrar", "Flexionar"),
        description = "Flexão dos joelhos em várias posições, foco em postura e alinhamento.",
        grade = 1,
        complexity = 1,
        typo = "Plie"
    ),
    Movement(
        name_official = "Tendu",
        synonyms = listOf("Estender", "Alongar"),
        description = "Movimento de extensão do pé no chão, frente, lado e trás.",
        grade = 1,
        complexity = 1,
        typo = "Tendu"
    ),
    Movement(
        name_official = "Dégagé",
        synonyms = listOf("Levantar", "Soltar o pé"),
        description = "Movimento onde o pé se levanta ligeiramente do chão.",
        grade = 1,
        complexity = 1,
        typo = "Degage"
    ),
    Movement(
        name_official = "Rond de Jambe à Terre",
        synonyms = listOf("Círculo de perna no chão"),
        description = "Desenhar círculos com a perna no chão, exige controle do quadril.",
        grade = 1,
        complexity = 2,
        typo = "Rond de Jambe a Terre"
    ),
    Movement(
        name_official = "Sauté",
        synonyms = listOf("Salto"),
        description = "Pequenos saltos no lugar, geralmente na primeira ou segunda posição.",
        grade = 1,
        complexity = 1,
        typo = "Saute"
    ),
    Movement(
        name_official = "Relevé",
        synonyms = listOf("Elevar"),
        description = "Elevar-se nas pontas dos pés, trabalhando o equilíbrio.",
        grade = 1,
        complexity = 2,
        typo = "Releve"
    ),
    Movement(
        name_official = "Échappé Sauté",
        synonyms = listOf("Abrir e fechar no salto"),
        description = "Salto onde os pés se afastam e depois se fecham.",
        grade = 1,
        complexity = 2,
        typo = "Echappe Saute"
    ),
    Movement(
        name_official = "Chassé",
        synonyms = listOf("Perseguir", "Deslizar"),
        description = "Um pé 'persegue' o outro em um movimento fluido.",
        grade = 1,
        complexity = 1,
        typo = "Chasse"
    ),
    Movement(
        name_official = "Pas de Bourrée",
        synonyms = listOf("Passo de transição"),
        description = "Pequenos passos em sequência para transições suaves.",
        grade = 1,
        complexity = 2,
        typo = "Pas de Bourree"
    ),
    Movement(
        name_official = "Port de Bras simples",
        synonyms = listOf("Movimento dos braços"),
        description = "Movimentos básicos dos braços, foco em fluidez e postura.",
        grade = 1,
        complexity = 1,
        typo = "Port de Bras simples"
    ),
    Movement(
        name_official = "Grand Battement",
        synonyms = listOf("Grande chute"),
        description = "Chutes amplos da perna, trabalhando força e flexibilidade.",
        grade = 2,
        complexity = 3,
        typo = "Grand Battement"
    ),
    Movement(
        name_official = "Glissade",
        synonyms = listOf("Deslizar"),
        description = "Movimento leve de deslize de um pé para o outro.",
        grade = 2,
        complexity = 2,
        typo = "Glissade"
    ),
    Movement(
        name_official = "Assemblé",
        synonyms = listOf("Reunir no salto"),
        description = "Salto onde os pés se encontram no ar, exigindo coordenação.",
        grade = 2,
        complexity = 3,
        typo = "Assemble"
    ),
    Movement(
        name_official = "Jeté",
        synonyms = listOf("Lançar"),
        description = "Salto de uma perna para a outra, com aterrissagem controlada.",
        grade = 2,
        complexity = 3,
        typo = "Jete"
    ),
    Movement(
        name_official = "Pas de Chat",
        synonyms = listOf("Salto do gato"),
        description = "Salto onde as pernas dobram no ar, lembrando um pulo de gato.",
        grade = 2,
        complexity = 3,
        typo = "Pas de Chat"
    ),
    Movement(
        name_official = "Pirouette simples",
        synonyms = listOf("Giro simples"),
        description = "Giro em relevé, focando em equilíbrio e controle.",
        grade = 2,
        complexity = 3,
        typo = "Pirouette simples"
    ),
    Movement(
        name_official = "Rond de Jambe en l'Air",
        synonyms = listOf("Círculo de perna no ar"),
        description = "Círculos feitos com a perna no ar, exigindo controle avançado do quadril.",
        grade = 3,
        complexity = 3,
        typo = "Rond de Jambe en l'Air"
    ),
    Movement(
        name_official = "Développé",
        synonyms = listOf("Desenvolver a perna"),
        description = "Elevar e estender a perna de forma lenta e controlada.",
        grade = 3,
        complexity = 4,
        typo = "Developpe"
    ),
    Movement(
        name_official = "Frappé",
        synonyms = listOf("Bater"),
        description = "Movimento rápido e brusco da perna, focando em precisão.",
        grade = 3,
        complexity = 3,
        typo = "Frappe"
    ),
    Movement(
        name_official = "Adagio",
        synonyms = listOf("Movimento lento"),
        description = "Movimentos lentos e controlados que desafiam o equilíbrio.",
        grade = 3,
        complexity = 4,
        typo = "Adagio"
    ),
    Movement(
        name_official = "Pirouette completa",
        synonyms = listOf("Giro completo"),
        description = "Giro completo em relevé, exigindo maior controle e técnica.",
        grade = 3,
        complexity = 4,
        typo = "Pirouette completa"
    ),
    Movement(
        name_official = "Sissonne",
        synonyms = listOf("Salto separado"),
        description = "Saltos de dois pés para um pé, com aterrissagem suave.",
        grade = 3,
        complexity = 3,
        typo = "Sissonne"
    ),
    Movement(
        name_official = "Grand Jeté",
        synonyms = listOf("Salto grande"),
        description = "Grande salto onde as pernas se estendem no ar.",
        grade = 3,
        complexity = 4,
        typo = "Grand Jete"
    ),
    Movement(
        name_official = "Pas de Valse",
        synonyms = listOf("Passo de valsa"),
        description = "Movimento fluido como na valsa, com foco em musicalidade.",
        grade = 3,
        complexity = 3,
        typo = "Pas de Valse"
    )
)
