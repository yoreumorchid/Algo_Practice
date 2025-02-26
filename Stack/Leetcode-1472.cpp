// Optimized Solution:
class BrowserHistory {
    vector<string> history;
    int len;
    int currentPage;
public:
    BrowserHistory(string homepage) {
        history.push_back(homepage);
        len = 1;
        currentPage = 0;
    }
    
    void visit(string url) {
        currentPage++;
        // Clear the forward pages
        if(currentPage == history.size()) {
            history.push_back(url);
        } else {
            history[currentPage] = url;
        }
        len = currentPage + 1;
    }
    
    string back(int steps) {
        currentPage = max(0, currentPage - steps);
        return history[currentPage];
    }
    
    string forward(int steps) {
        currentPage = min(currentPage + steps, len - 1);
        return history[currentPage];
    }
};
// Time Complexity: O(n)
// Space Complexity: O(n)