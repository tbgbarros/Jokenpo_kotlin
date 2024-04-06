package com.example.jokenpo

import kotlin.random.Random

class Jogo {
    enum class Escolha {
        PEDRA, PAPEL, TESOURA
    }

    fun jogadaComputador(): Escolha {
        val randomInt = Random.nextInt(3)
        return when (randomInt) {
            0 -> Escolha.PEDRA
            1 -> Escolha.PAPEL
            else -> Escolha.TESOURA
        }
    }

    fun determinarVencedor(escolhaUsuario: Escolha, escolhaComputador: Escolha): String {
        return when {
            escolhaUsuario == escolhaComputador -> "Empate!"
            escolhaUsuario == Escolha.PEDRA && escolhaComputador == Escolha.TESOURA ||
                    escolhaUsuario == Escolha.PAPEL && escolhaComputador == Escolha.PEDRA ||
                    escolhaUsuario == Escolha.TESOURA && escolhaComputador == Escolha.PAPEL -> "Você venceu!"
            else -> "Você perdeu!"
        }
    }
}