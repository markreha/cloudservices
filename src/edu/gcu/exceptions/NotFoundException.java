package edu.gcu.exceptions;

/**
 * Checked Exception thrown if a search has no results
 *
 * @author $author$
 * @version $Revision$
 */
public class NotFoundException extends Exception 
{
    static final long serialVersionUID = 0;

    /**
     * Creates a new NotFoundException object.
     */
    public NotFoundException()
    {
    }

    /**
     * Creates a new NotFoundException object.
     *
     * @param msg Error Message
     */
    public NotFoundException(String msg)
    {
        super(msg);
    }
}
