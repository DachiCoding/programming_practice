
class StringNode {
    private:
        string elem;
        stringNode* next;
        friend class StringLinkedList;
};

class StringLinkedList {
    public:
        StringLinkedList();
        ~StringLinkedList();
        bool empty() const;
        const string& front() const;
        void addFront(const string& e);
        void removeFront();

    private:
        StringNode* head;
};


