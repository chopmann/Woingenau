package woingenau.auth

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole implements Serializable {

    private static final long serialVersionUID = 1

    SecUser user
    SecRole role

    boolean equals(other) {
        if (!(other instanceof UserRole)) {
            return false
        }

        other.user?.id == user?.id &&
                other.role?.id == role?.id
    }

    int hashCode() {
        def builder = new HashCodeBuilder()
        if (user) builder.append(user.id)
        if (role) builder.append(role.id)
        builder.toHashCode()
    }

    static UserRole get(long userId, long roleId) {
        UserRole.where {
            user == SecUser.load(userId) &&
                    role == SecRole.load(roleId)
        }.get()
    }

    static boolean exists(long userId, long roleId) {
        UserRole.where {
            user == SecUser.load(userId) &&
                    role == SecRole.load(roleId)
        }.count() > 0
    }

    static UserRole create(SecUser user, SecRole role, boolean flush = false) {
        def instance = new UserRole(user: user, role: role)
        instance.save(flush: flush, insert: true)
        instance
    }

    static boolean remove(SecUser u, SecRole r, boolean flush = false) {
        if (u == null || r == null) return false

        int rowCount = UserRole.where {
            user == SecUser.load(u.id) &&
                    role == SecRole.load(r.id)
        }.deleteAll()

        if (flush) {
            UserRole.withSession { it.flush() }
        }

        rowCount > 0
    }

    static void removeAll(SecUser u, boolean flush = false) {
        if (u == null) return

        UserRole.where {
            user == SecUser.load(u.id)
        }.deleteAll()

        if (flush) {
            UserRole.withSession { it.flush() }
        }
    }

    static void removeAll(SecRole r, boolean flush = false) {
        if (r == null) return

        UserRole.where {
            role == SecRole.load(r.id)
        }.deleteAll()

        if (flush) {
            UserRole.withSession { it.flush() }
        }
    }

    static constraints = {
        role validator: { SecRole r, UserRole ur ->
            if (ur.user == null) return
            boolean existing = false
            UserRole.withNewSession {
                existing = UserRole.exists(ur.user.id, r.id)
            }
            if (existing) {
                return 'userRole.exists'
            }
        }
    }

    static mapping = {
        id composite: ['role', 'user']
        version false
    }
}
