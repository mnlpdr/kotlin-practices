/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 * 
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 * 
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }

        println()
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(materia: String){

}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia: String, vararg nota: Double) {
    // Se a matéria já existe, apenas adiciona as novas notas
    if (materiasENotas.containsKey(materia)) {
        materiasENotas[materia]?.addAll(nota.toList())
    } else {
        // Se a matéria não existe, cria uma nova entrada com as notas fornecidas
        println("As notas não foram adicionadas pois a matéria não está cadastrada.")
    }
}
fun main(){


    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional

    val novaMateria = "PDM"
    val notasNovaMateria = mutableListOf(10.0, 9.0, 9.5)

    val resultado = adicionarDisciplina(novaMateria, notasNovaMateria)

    if(resultado) {
        println("Disciplina atualizada com sucesso.")
    } else {
        println("Nova disciplina adicionada com sucesso.")
    }

    println("Conteúdo de materiasENotas após adição:")
    println(materiasENotas)


    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada

    val sucesso = adicionarDisciplina(notas = mutableListOf(9.5, 8.0, 7.5), materia = "Matemática")

    if (sucesso) {
        println("Disciplina atualizada com sucesso.")
    } else {
        println("Nova disciplina adicionada com sucesso.")
    }

    println("Conteúdo de materiasENotas após atribuição nomeada:")
    println(materiasENotas)
    
    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()

    //Alterei lá em cima. Ficou assim:
                /*  fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
                    return materiasENotas.put(materia, notas) != null
                }
                */

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas


    adicionarDisciplina("PWeb2")

    println("\nApós adicionar Pweb2:")
    println(materiasENotas)

    
    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas

    adicionarNota("PDM", 10.0)
    adicionarNota("PDM", 8.0)
    adicionarNota("PDM", 9.0)
    adicionarNota("PWeb2", 10.0)
    adicionarNota("PWeb2", 8.0)
    adicionarNota("PWeb2", 9.0)
    adicionarNota("Matemática", 10.0)
    adicionarNota("Matemática", 8.0)
    adicionarNota("Matemática", 9.0)

    println("\nApós questão 5:")
    println(materiasENotas)
    
    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas

    println("\nQuestão 6:")
    mostrarNotas("PDM")
    mostrarNotas("Matemática")
    mostrarNotas("PWeb2")
    
    // 7. adicionarDisciplina -> adicione mais 1 disciplina

    println("\nQuestão 7:")
    adicionarDisciplina("PPS")
    println("Adicionada PPS")
    println(materiasENotas)
    
    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();

    //Feito.

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    println("\nQuestão 9:")
    adicionarVariasNotas("PPS", 9.0, 8.0, 7.5)
    println(materiasENotas)
    
    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    println("\nQuestão 10:")
    mostrarNotas("PPS")

    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)
    
    // 11: calcularMedia -> Implemente a função calcularMedia()
    
    // 12: calcularMedia -> calcule a media de 2 disciplinas
    
    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    
    // 14: mostrarNotas -> mostre as notas de 1 disciplina 

}