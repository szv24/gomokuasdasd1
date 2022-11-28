## Iterator

```c++
class iterator{
    public:
        student& operator*(){
            return *p;
        }
        
        student* operator->(){
            return p;
        }
        
        iterator operator++(){
            ++p;
            return *this;
        }
        
        iterator operator++(int){
            iterator tmp(*this);
            operator++();
            return tmp;
        }

        bool operator==(const iterator &rhs) const {
            return p == rhs.p && mark == rhs.mark;
        }

        bool operator!=(const iterator &rhs) const {
            return !(rhs == *this);
        }

    private:
        iterator(const student *p, const student *e, unsigned mark) : start(p), p(p), e(e), mark(mark) {}
        student *p = nullptr, *start = nullptr, *e = nullptr;
        unsigned mark = 0;
        
        friend class students;

    };
    
    iterator begin(){
        auto it = iterator(s,s+n,0);
        ++it;
    }
    
    iterator end(){
        return iterator(s+n,s+n,5);
    }
```

## Meta

```c++
template<const char* STR, size_t N>
struct capital_letters {
  static const unsigned value = ('A' <= STR[N-1] && STR[N-1] <= 'Z' ? 1 : 0) + capital_letters<STR, N-1>::value;
};

template<const char* STR>
struct capital_letters<STR, 0> {
  static const unsigned value = 0;
};
```

## STL

```c++
bool vector_to_map(const vector<person>& pv, map<string, unsigned>& pm){
    for(const auto& [n,i] : pv){
        if(pm.find(n) != pm.end()){
            return false;
        } else {
            pm[n] = i;
        }
    }
    return true;
}
```

```c++
unsigned vector_set_to_set(const vector<set<unsigned>>& input, set<unsigned>& output){
    unsigned result = 0;
    for(const auto& item : input){
        for(const auto& x : item){
            if(output.find(x) != output.end()){
                result+=x;
            } else {
                output.insert(x);
            }
        }
    }
    return result;
}
```

