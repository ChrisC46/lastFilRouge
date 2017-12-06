
package entites;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
                                                                            ==(W{==========-      /===-
                                                                              ||  (.--.)         /===-_---~~~~~~~~~------____
                                                                              | \_,|**|,__      |===-~___                _,-'  
                                                                     -==\\        `\ ' `--'   ),    `//~\\   ~~~~`---.___.-~~
                                                             ______-==|        /`\_. .__/\ \    | |  \\           _-~`
                                                       __--~~~  ,-/-==\\      (   | .  |~~~~|   | |   `\        ,'
                                                    _-~       /'    |  \\     )__/==0==-\<>/   / /      \      /
                                                 .'        /       |   \\      /~\___/~~\/  /' /        \   /'
                                                 /  ____  /         |    \`\.__/-~~   \  |_/'  /          \/'
           _,.-Y  |  |  Y-._                             /-'~    ~~~~~---__  |     ~-/~         ( )   /'        _--~`
       .-~"   ||  |  |  |   "-.                                            \_|      /        _) | ;  ),   __--~~
       I" ""=="|" !""! "|"[]""|                                             '~~--_/      _-~/- |/ \   '-~ \             
  L__  [] |..------|:   _[----I" .-{"-.                                    {\__--_/}    / \\_>-|)<__\      \
  I___|  ..| l______|l_ [__L]_[I_/r(=}=-P  -   -   -   -   -            /'   (_/  _-~  | |__>--<__|      | 
  [L______L_[________]______j~  '-=c_]/=-^                            |   _/) )-~     | |__>--<__|      |   
       \_I_j.--.\==I|I==_/.--L_]                                     / /~ ,_/       / /__>---<__/      |  
         [_((==)[`-----"](==)j                                       o-o _//        /-~_>---<__-~      / 
           I--I"~~"""~~"I--I                                         (^(~          /~_>---<__-      _-~              
           |[]|         |[]|                                        ,/|           /__>--<__/     _-~                 
           l__j         l__j                                     ,//('(          |__>--<__|     /                  .----_ 
           |!!|         |!!|                                    ( ( '))          |__>--<__|    |                 /' _---_~\
           |..|         |..|                                 `-)) )) (           |__>--<__|    |               /'  /     ~\`\
           ([])         ([])                                 ,/,'//( (             \__>--<__\    \            /'  //        ||
           ]--[         ]--[                                ,( ( ((, ))              ~-__>--<_~-_  ~--____---~' _/'/        /'
           [_L]         [_L]                               `~/  )` ) ,/|                 ~-_~>--<_/-__       __-~ _/ 
          /|..|\       /|..|\                              ._-~//( )/ )) `                    ~~-'_/_/ /~~~~~~~__--~ 
         `=}--{='     `=}--{='                             ;'( ')/ ,)(                              ~~~~~~~~~~ 
        .-^--r-^-.   .-^--r-^-.
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Entity
public class BigBaldsBurgers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BigBaldsBurgers)) {
            return false;
        }
        BigBaldsBurgers other = (BigBaldsBurgers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.BigBaldsBurgers[ id=" + id + " ]";
    }

}
