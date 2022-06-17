open class Singleton<out O, in P>(private val create: (P) -> O)) {
  @Volatile
  private instantce: O? = null
  
  fun getInstance(p: P): O {
    return instance?: synchronized(this) {
      instance?: create(p).apply{
        instance = this
      }
    }
  }
}


// Then write the `Clazz` companion object like the following. 
// While the `SomeType` is the type of the parameter

class Clazz(val p: SomeType) {
  companion object: Singleton<Clazz, SomeType>(::Clazz)
}


// by calling the `Clazz` use `Clazz.getInstance(p)`
