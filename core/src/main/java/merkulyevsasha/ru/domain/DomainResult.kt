package merkulyevsasha.ru.domain

sealed class DomainResult<L, R> {
    data class Left<L, R>(val result: L) : DomainResult<L, R>()
    data class Right<L, R>(val exception: R) : DomainResult<L, R>()

    fun result(f: (L) -> (Unit)): DomainResult<L, R> {
        when (this) {
            is Left -> f(this.result)
        }
        return this
    }

    fun exception(f: (R) -> (Unit)): DomainResult<L, R> {
        when (this) {
            is Right -> f(this.exception)
        }
        return this
    }
}