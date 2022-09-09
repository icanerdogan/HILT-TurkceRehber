<h1 align="center"> HILT Türkçe Öğretici Rehber </h1>

<h2> Dependency Injection </h2>
  
<p> Dependency injection, bir sınıfın/nesnenin bağımlılıklardan kurtulmasını amaçlayan ve o nesneyi olabildiğince bağımsızlaştıran bir programlama tekniği/prensibidir. Dependency Injection, bağımlılıkları soyutlamak demektir.</p>  
<p>Bağımlılık oluşturacak parçaların ayrılıp, bunların dışardan verilmesiyle sistem içerisindeki bağımlılığı minimize etme işlemidir.
	Yazılımı oluşturan yapılar kaçınılmaz olarak birbirleri ile ilişkilidir. Bu ilişkinin bir bağa ve sınırlandırmaya sebep olmaması için mümkün mertebe ilişkiyi gevşek tutmak önemlidir. Biz buna Loosely Coupled yani Gevşek Bağlılık diyoruz. Bundan dolayı yazılımı oluşturan yapıların birbirleri ile olan sıkı bağ azalacağı için uygulamaya yeni özellikler eklenip çıkartılabilmesi kolay hale gelecektir.</p>
<p>Dependency Injection kodun yeniden kullanılabilirliği, yeniden düzenleme kolaylığı ve test kolaylığı olmak üzere 3 farklı avantaj sağlamaktadır.</p>  
<ul>
  <li> Sınıfların yeniden kullanılabilirliği ve bağımlılıkların ayrıştırılması: Bir bağımlılığın uygulamalarını değiştirmek daha kolaydır. Kontrolün tersine çevrilmesi nedeniyle kodun yeniden kullanımı geliştirildi ve sınıflar artık bağımlılıklarının nasıl oluşturulduğunu kontrol etmiyor, bunun yerine herhangi bir konfigürasyonla çalışıyor.</li>
  <li> Yeniden düzenleme kolaylığı: Bağımlılıklar API yüzeyinin doğrulanabilir bir parçası haline gelir, böylece uygulama ayrıntıları olarak gizlenmek yerine nesne oluşturma veya derleme zamanında kontrol edilebilirler. </li>
  <li> Test kolaylığı: Bir sınıf bağımlılıklarını yönetmez, bu nedenle onu test ederken, tüm farklı durumlarınızı test etmek için farklı uygulamalardan geçebilirsiniz.    </li>
</ul>
<a href="https://www.ilkayilknur.com/dependency-injection-nedir"> <b> Dependency Injection Örnek Uygulaması </b> </a>

<h3>Dependency Injection Basit Uygulama</h3>
<p>Sınıflar genellikle diğer sınıflara referanslar gerektirir.  Örnek olarak "Car" sınıfı "Engine" sınıfına ihtiyacı yani bağımlılığı vardır.</p>  
<p><b>Aşağıdaki kullanım bir Dependency Injection değildir!</b></p>
<img src="https://raw.githubusercontent.com/icanerdogan/HILT-TurkceRehber/master/images/1-car-engine-no-di.png">

```
class Car { 
    private val engine = Engine() 
    fun start() { 
        engine.start() 
    } 
} 
fun main(args: Array) { 
    val car = Car() 
    car.start() 
}
```
<p><b>Aşağıdaki kullanım bir Constructor Injection örneğidir!</b></p>
<img src="https://raw.githubusercontent.com/icanerdogan/HILT-TurkceRehber/master/images/1-car-engine-di.png">
<p> Bu kullanımda görüldüğü üzere Engine sınıfı başka sınıflar içinde kullanılabilir hale gelmiştir. Eğer Car sınıfı ElectricEngine kullanmak istediğinde, Engine olarak oluşturulan bu sınıfı eklemek olacaktır. </p>

```
class Car(private val engine: Engine) { 
    fun start() { 
        engine.start() 
    } 
} 
fun main(args: Array) { 
    val engine = Engine() 
    val car = Car(engine) 
    car.start() 
}
```
<p><b>Aşağıdaki kullanım bir Field Injection (or Setter Injection) örneğidir!</b></p>
<p> Activity ve Fragment gibi sınıflar sistem tarafından başlatılabilir bu nedenle yapıcı Constructor Injection kullanılması mümkün değildir.  Field Injection ile sınıf oluşturulduktan sonra bağımlılıklar somutlaştırılır. </p>

```
class Car { 
    lateinit var engine: Engine 
    fun start() { 
        engine.start() 
    } 
} 
fun main(args: Array) { 
    val car = Car() 
    car.engine = Engine() 
    car.start() 
}
```
<p> Dagger üzerine kurulan HILT sayesinde örnekleri verilen Dependency Injection daha hızlı şekilde yapılabilmektedir. </p>

<h2> HILT </h2>
<p>Coming Sooooooon!</p>
