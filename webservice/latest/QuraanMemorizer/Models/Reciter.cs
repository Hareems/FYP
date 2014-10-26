using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;


namespace QuraanMemorizer.Models
{
    public class Reciter
    {
        public int Id { get; set; }
        
        [StringLength(50, MinimumLength = 1)]
        public string ReciterName { get; set; }

        public  ICollection<QuraanAudio> QuraanAudios { get; set; }
    }
}