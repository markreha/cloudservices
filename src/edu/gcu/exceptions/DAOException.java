package edu.gcu.exceptions;

/**
 * Runtime Exception thrown Database Exception
 *
 * @author $author$
 * @version $Revision$
 */
public class DAOException extends RuntimeException 
{
    static final long serialVersionUID = 0;

    /**
     * Creates a new DAOException object.
     */
    public DAOException()
    {
    }
    
    /**
     * Creates a new DAOException object.
     *
     * @param msg Error Message
     * @param e Source Exception
     */
    public DAOException(String msg, Exception e)
    {
        super(msg, e);
    }
}
