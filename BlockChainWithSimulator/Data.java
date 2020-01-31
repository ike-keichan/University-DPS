/**
* This class is the implementation of data that is included in a block.
*
* @author Naohiro Hayashibara
*
*/

public class Data extends Object
{
    private String data;

    /**
     * The constructor of {@link Data}.
     * @param data data represented as a {@code String}.
     */
    public Data(String data)
    {
        this.setContent(data);

        return;
    }

    /**
     * Set {@code String} as {@link Data}.
     * @param data {@code String} put into the content of data.
     */
    public void setContent(String data)
    {
        this.data = data;

        return;
    }

    /**
     * Get {@code String} as {@link Data}.
     * @return Return {@code String}.
     */
    public String getContent()
    {
        return this.data;
    }
}
