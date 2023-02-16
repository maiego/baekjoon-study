#include <bits/stdc++.h>
using namespace std;
using ii = pair<int,int>;

#define N 5'000'001

int n,k;
int arr[N];

int main() {
  ios::sync_with_stdio(false); cin.tie(0);

  int n,k; cin>>n>>k;
  for (int i=0; i<n; ++i)
    cin>>arr[i];

  priority_queue<ii, vector<ii>, greater<ii>> pq;
  for (int i=0; i<n; ++i) {
    pq.push({arr[i], i});
    while (pq.top().second <= i-k)
      pq.pop();

    cout << pq.top().first << " ";
  }

  return 0;
}