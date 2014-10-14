package woingenau

class Kurs {
	
	String name
	String owner
	String info
	static hasMany = [termine: Termin]

    static constraints = {
    }
}
