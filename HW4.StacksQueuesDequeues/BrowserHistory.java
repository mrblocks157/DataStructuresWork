public class BrowserHistory {
    /*
    BrowserHistory(String homePage) constructor-> Creates a new object with homepage as the first website visited
    visit(String url) -> Visits url and clears any forward history.
    back(int steps) -> move steps back in history and return the corresponding url. If there are not enough websites to move steps back move to the last available one.
    forward(int steps) -> move steps forward in history and return the corresponding url. If there are not enough websites to move steps forward move the the last one available.
     */
    Deque<String> browser;
    DequeNode<String> it;
    public BrowserHistory(String homePage){
        it = new DequeNode<String>(homePage);
        this.browser = new Deque<String>(it);
    }

    public void visit(String url){
        if(browser.end == it){
            browser.append(url);
            it = it.getNext();
        }
        else{
            it.setNext(new DequeNode<String>(url));
            it = it.getNext();
            browser.end = it;
        }
    }

    public String back(int steps){
        for (int i =0; i<steps; i++){
            if (it.getPrev()!=null){
                it = it.getPrev();
            }
            else{
                return it.value();
            }
        }
        return it.value();
    }

    public String forward(int steps){
        for (int i =0; i<steps; i++){
            if (it.getNext()!=null){
                it = it.getNext();
            }
            else{
                return it.value();
            }
        }
        return it.value();
    }
}
