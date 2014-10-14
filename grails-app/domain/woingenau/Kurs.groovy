package woingenau

class Kurs {
	
	String owner
	String name
	String info
	static hasMany = [termine: Termin]

    static constraints = {
    }
}
