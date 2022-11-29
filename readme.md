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
        
        iterator& operator++(){
            ++p;
            while (p != end && p->mark != mark)
                ++p;
            if (p == end) {
                if (mark == 5)
                    return *this;
                else {
                    mark++;
                    p = start-1;
                    return operator++();
                }
            }
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

## Iterator STL stuff

```c++
iterator& operator++() {
      ++si;
      if (si == (*v)[vi].length()) {
        si = 0;
        ++vi;
        
        while (vi < v->size() && (*v)[vi].empty())
          ++vi;
      }
      return *this;
    }
    
    char& operator*() {
      return (*v)[vi][si];
    }
    
    private:
    vector<string>* v;
    size_t vi, si = 0; // vege: vi == v.size()
    
    friend class strings;

    iterator(vector<string>* v, size_t vi = 0) : v(v), vi(vi) {
    }
    
    //fo osztaly
    iterator begin() {
    size_t vi = 0;
    while (vi < v.size() && v[vi].empty())
      ++vi;
    return iterator(&v, vi);
  }
  
  iterator end() {
    return iterator(&v, v.size());
  }
  
  
  //STACK-es azaz pointeres, mikor pointerek mutatnak a következő/előző elemre:
class iterator {
  public:
    iterator() : _p(nullptr) { }

    iterator(const iterator &it) : _p(it._p) { }

    T& operator*() {
      return _p->adat;
    }

    T* operator->() {
      return &(_p->adat);
    }

    iterator& operator++() {
      _p = _p->kov;
      return *this;
    }

    iterator operator++(int) {
      iterator temp(*this);
      _p = _p->kov;
      return temp;
    }

    iterator& operator--() {
      _p = _p->elozo;
      return *this;
    }

    iterator operator--(int) {
      iterator temp(*this);
      _p = _p->elozo;
      return temp;
    }

    bool operator==(const iterator &it) const {
      return _p == it._p;
    }

    bool operator!=(const iterator &it) const {
      return _p != it._p;
    }

  private:
    iterator(Elem *p) : _p(p) { }

    Elem *_p;
    friend class Stack<T>;
  };

//FŐ osztályba:
  iterator begin() {
    return iterator(fej);
  }

  iterator end() {
    return iterator(nullptr);
  }
    
```
