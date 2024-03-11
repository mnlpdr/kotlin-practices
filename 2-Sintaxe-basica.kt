package br.ifpb.pdm.praticas

class Livro(var titulo: String, var preco: Double) {
    override fun toString(): String {
        return "Livro: Titulo = $titulo, Preco = $preco"
    }
}

fun menu() {
    println("1 - Cadastrar livro")
    println("2 - Excluir livro")
    println("3 - Buscar livro")
    println("4 - Editar livro")
    println("5 - Listar livros")
    println("6 - Listar livros que começam com letra escolhida")
    println("7 - Listar livros com preço abaixo do informado")
    println("8 - Sair")
}

fun inputTitulo(): String {
    print("Digite o titulo do livro: ")
    return readlnOrNull() ?:""
}

fun inputPreco(): Double {
    print("Digite o preco do livro: ")

    var preco: Double = readlnOrNull()!!.toDouble()
    do {
        print("Digite o preço do livro:")
        val input = readlnOrNull()
        preco = try {
            input?.toDouble() ?: -1.0
        } catch (e: NumberFormatException) {
            -1.0
        }
        if (preco < 0) {
            println("O preço não pode ser negativo ou inválido. Tente novamente.")
        }
    } while (preco < 0)


    return preco
}

fun cadastrarLivro(repositorio: MutableList<Livro>) {
    val titulo = inputTitulo()
    val preco = inputPreco()

    repositorio.add(Livro(titulo, preco))
    println("\nCadastrado com sucesso!\n")
}

fun excluirLivro(repositorio: MutableList<Livro>) {
    val livro = buscarNome(repositorio)
    if (livro in repositorio) {
        repositorio.remove(livro)
        println("Livro removido com sucesso!")
    } else {
        println("Livro não foi removido pois já não constava na lista.")
    }

}

fun buscarNome(repositorio: MutableList<Livro>): Livro? {
    val titulo = inputTitulo()
    return repositorio.find { it.titulo == titulo }
}

fun editarLivro(repositorio: MutableList<Livro>) {
//    println("Editar livro")
//    val livroEditar = inputTitulo()
//    var livro = repositorio.find {it.titulo == livroEditar}
//
//    println("Editando $livro")
//    println("Insira as alterações:")
//    var novoTitulo = inputTitulo()
//    var novoPreco = inputPreco()
//
//    if (livro != null) {
//        livro.titulo = novoTitulo
//
//    }
    val livro = buscarNome(repositorio)
    if (livro == null) {
        println("Livro não encontrado.")
        return
    }
    println("Editar livro: ${livro.titulo}")
    println("Deseja editar o título, preço, ou ambos? [Título - Digite 1/preço - Digite 2/ambos - Digite 3]")
    when (readlnOrNull()) {
        "1" -> {
            val novoTitulo = inputTitulo()
            livro.titulo = novoTitulo
            println("Título atualizado com sucesso.")
        }
        "2" -> {
            val novoPreco = inputPreco()
            livro.preco = novoPreco
            println("Preço atualizado com sucesso.")
        }
        "3" -> {
            val novoTitulo = inputTitulo()
            val novoPreco = inputPreco()
            livro.titulo = novoTitulo
            livro.preco = novoPreco
            println("Título e preço atualizados com sucesso.")
        }
        else -> println("Opção inválida.")
    }
}

fun listar(repositorio: MutableList<Livro>) {
    println("\nLista de livros:\n")
    for (livro in repositorio) { println(livro) }
    if (repositorio.isEmpty()) {
        println("Nenhum livro cadastrado.")
    }
}

fun listarComLetraInicial(repositorio: MutableList<Livro>) {
    print("Informe a letra: ")
    var letra = readlnOrNull() ?:""

    while(letra.length > 1) {
        print("Informe apenas uma letra: ")
        letra = readlnOrNull() ?:""
    }

    if(letra != "") {
        val livros = repositorio.filter { it.titulo.startsWith(letra) }
        livros.forEach {println(it)}
    } else {
        println("É necessário informar pelo menos um caracter para esta função executar!")
    }
}

fun listarComPrecoAbaixo(repositorio: MutableList<Livro>) {
    val preco = inputPreco()
    val livros = repositorio.filter { it.preco < preco }
    livros.forEach { println(it) }
}

fun main() {
    val repositorioLivros = mutableListOf<Livro>()
    repositorioLivros.add(Livro("Livro dos Livros", 999999.99))
    repositorioLivros.add(Livro("Turma da Monica", 4.99))
    repositorioLivros.add(Livro("Kotlin for Dummies", 29.99))
    repositorioLivros.add(Livro("A", 59.99))

    var opcao = 0
    while (opcao != 8) {
        menu()
        println(repositorioLivros[0])
        print("Digite a opção: ")
        opcao = readlnOrNull()?.toInt() ?:8

        when (opcao) {
            1 -> cadastrarLivro(repositorioLivros)
            2 -> excluirLivro(repositorioLivros)
            3 -> {
                val livro = buscarNome(repositorioLivros)
                println(livro)
            }
            4 -> editarLivro(repositorioLivros)
            5 -> listar(repositorioLivros)
            6 -> listarComLetraInicial(repositorioLivros)
            7 -> listarComPrecoAbaixo(repositorioLivros)
            8 -> println("Até a próxima :)")
        }
        Thread.sleep(3000)
    }
}