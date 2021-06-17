# N 과 M

## https://www.acmicpc.net/problem/15649

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static HashSet<Integer> set;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    set = new HashSet<Integer>();

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    for (int i = 1; i <= n; i++) {
      if (set.contains(i)) {
        continue;
      }
      arr[lastIdx] = i;

      set.add(i);
      pick(arr, lastIdx + 1);
      set.remove(i);
    }
  }
}
```

## https://www.acmicpc.net/problem/15650

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    int min = lastIdx > 0 ? arr[lastIdx - 1] + 1 : 1;
    for (int i = min; i <= n; i++) {
      arr[lastIdx] = i;
      pick(arr, lastIdx + 1);
    }
  }
}

```

## https://www.acmicpc.net/problem/15651

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    for (int i = 1; i <= n; i++) {
      arr[lastIdx] = i;
      pick(arr, lastIdx + 1);
    }
  }
}
```


## https://www.acmicpc.net/problem/15652

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    printPermutation(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void printPermutation(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    int min = lastIdx > 0 ? arr[lastIdx - 1] : 1;
    for (int i = min; i <= n; i++) {
      arr[lastIdx] = i;
      printPermutation(arr, lastIdx + 1);
    }
  }
}
```

## https://www.acmicpc.net/problem/15654

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static HashSet<Integer> set;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    set = new HashSet<Integer>();

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    for (int i = 0; i < n; i++) {
      int el = inputArr[i];
      if (set.contains(i)) {
        continue;
      }
      arr[lastIdx] = el;

      set.add(i);
      pick(arr, lastIdx + 1);
      set.remove(i);
    }
  }
}
```

## https://www.acmicpc.net/problem/15655

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0, 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx, int minIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    for (int i = minIdx; i < n; i++) {
      int el = inputArr[i];
      arr[lastIdx] = el;
      pick(arr, lastIdx + 1, i + 1);
    }
  }
}
```

## https://www.acmicpc.net/problem/15656

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    for (int i = 0; i < n; i++) {
      int el = inputArr[i];
      arr[lastIdx] = el;
      pick(arr, lastIdx + 1);
    }
  }
}
```

## https://www.acmicpc.net/problem/15657

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0, 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx, int minIdx) throws IOException {
    if (lastIdx == r) {
      for (int i = 0; i < r; i++) {
        bw.write(arr[i] + " ");
      }
      bw.newLine();
      return;
    }
    for (int i = minIdx; i < n; i++) {
      int el = inputArr[i];
      arr[lastIdx] = el;
      pick(arr, lastIdx + 1, i);
    }
  }
}
```

## https://www.acmicpc.net/problem/15663

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static HashSet<Integer> set;
  public static HashSet<String> outputSet;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    set = new HashSet<Integer>();
    outputSet = new HashSet<String>();

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < r; i++) {
        sb.append(arr[i] + " ");
      }
      if (outputSet.add(sb.toString())) {
        for (int i = 0; i < r; i++) {
          bw.write(arr[i] + " ");
        }
        bw.newLine();
      }
      return;
    }
    for (int i = 0; i < n; i++) {
      int el = inputArr[i];
      if (set.contains(i)) {
        continue;
      }
      arr[lastIdx] = el;

      set.add(i);
      pick(arr, lastIdx + 1);
      set.remove(i);
    }
  }
}
```

## https://www.acmicpc.net/problem/15664

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static HashSet<String> outputSet;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    outputSet = new HashSet<String>();

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0, 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx, int minIdx) throws IOException {
    if (lastIdx == r) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < r; i++) {
        sb.append(arr[i] + " ");
      }
      if (outputSet.add(sb.toString())) {
        for (int i = 0; i < r; i++) {
          bw.write(arr[i] + " ");
        }
        bw.newLine();
      }
      return;
    }
    for (int i = minIdx; i < n; i++) {
      int el = inputArr[i];
      arr[lastIdx] = el;
      pick(arr, lastIdx + 1, i + 1);
    }
  }
}
```

## https://www.acmicpc.net/problem/15665

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static HashSet<String> outputSet;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    outputSet = new HashSet<String>();

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx) throws IOException {
    if (lastIdx == r) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < r; i++) {
        sb.append(arr[i] + " ");
      }
      if (outputSet.add(sb.toString())) {
        for (int i = 0; i < r; i++) {
          bw.write(arr[i] + " ");
        }
        bw.newLine();
      }
      return;
    }
    for (int i = 0; i < n; i++) {
      int el = inputArr[i];
      arr[lastIdx] = el;
      pick(arr, lastIdx + 1);
    }
  }
}
```

## https://www.acmicpc.net/problem/15666

```java
import java.util.*;
import java.io.*;

public class Main {
  public static BufferedWriter bw;
  public static BufferedReader br;
  public static StringTokenizer st;
  public static int n;
  public static int r;
  public static HashSet<String> outputSet;
  public static int[] inputArr;

  public static void main(String[] args) throws IOException {
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    br = new BufferedReader(new InputStreamReader(System.in));
    st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    r = Integer.parseInt(st.nextToken());
    outputSet = new HashSet<String>();

    inputArr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      inputArr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(inputArr);

    pick(new int[r], 0, 0);

    br.close();
    bw.flush();
    bw.close();
  }

  public static void pick(int[] arr, int lastIdx, int minIdx) throws IOException {
    if (lastIdx == r) {
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < r; i++) {
        sb.append(arr[i] + " ");
      }
      if (outputSet.add(sb.toString())) {
        for (int i = 0; i < r; i++) {
          bw.write(arr[i] + " ");
        }
        bw.newLine();
      }
      return;
    }
    for (int i = minIdx; i < n; i++) {
      int el = inputArr[i];
      arr[lastIdx] = el;
      pick(arr, lastIdx + 1, i);
    }
  }
}
```
