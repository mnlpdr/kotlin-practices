open class Funcionario(val nome: String, val idade: Int) {
    init {
        println("Novo funcionário registrado: $nome, $idade anos")
    }

    open fun apresentar() {
        println("Olá, meu nome é $nome e eu tenho $idade anos.")
    }
}

class Gerente(nome: String, idade: Int, val setor: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        super.apresentar()
        println("Eu sou gerente do setor de $setor.")
    }
}

class Desenvolvedor(nome: String, idade: Int, val linguagem: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        super.apresentar()
        println("Eu programo em $linguagem.")
    }
}

class Analista(nome: String, idade: Int, val area: String) : Funcionario(nome, idade) {
    override fun apresentar() {
        super.apresentar()
        println("Minha área de especialização é $area.")
    }
}

fun main() {
    val funcionarios = listOf<Funcionario>(
        Gerente("Alice", 30, "TI"),
        Desenvolvedor("Bob", 25, "Kotlin"),
        Analista("Carol", 28, "Financeira")
    )

    funcionarios.forEach { funcionario ->
        when (funcionario) {
            is Gerente -> funcionario.apresentar()
            is Desenvolvedor -> funcionario.apresentar()
            is Analista -> funcionario.apresentar()
            else -> println("Tipo de funcionário não identificado.")
        }
    }
}
