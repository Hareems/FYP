using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Data.Entity.Infrastructure;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Description;
using QuraanMemorizer.Models;
using QuraanMemorizer.DAL;

namespace QuraanMemorizer.Controllers
{ 
    public class JuzzController : ApiController
    {   
        private ApplicationDbContext db = new ApplicationDbContext();

        // GET api/Juzz
    
        [HttpGet]
        public IQueryable<Juzz> GetJuzz(string Id = null, string juzzName = null)
        {
         
            if (Id != null)
                return db.Juzz.Where(s => s.JuzzId == int.Parse(Id));
            if (juzzName != null)
                return db.Juzz.Where(s => s.JuzzName == juzzName);
         
            return db.Juzz;

        }

        // GET api/Juzz/5
        [ResponseType(typeof(Juzz))]
        public IHttpActionResult GetJuzz(int id)
        {
            Juzz juzz = db.Juzz.Find(id);
            if (juzz == null)
            {
                return NotFound();
            }

            return Ok(juzz);
        }

        // PUT api/Juzz/5
        public IHttpActionResult PutJuzz(int id, Juzz juzz)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            if (id != juzz.JuzzId)
            {
                return BadRequest();
            }

            db.Entry(juzz).State = EntityState.Modified;

            try
            {
                db.SaveChanges();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!JuzzExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return StatusCode(HttpStatusCode.NoContent);
        }

        // POST api/Juzz
        [ResponseType(typeof(Juzz))]
        public IHttpActionResult PostJuzz(Juzz juzz)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            db.Juzz.Add(juzz);
            db.SaveChanges();

            return CreatedAtRoute("DefaultApi", new { id = juzz.JuzzId }, juzz);
        }

        // DELETE api/Juzz/5
        [ResponseType(typeof(Juzz))]
        public IHttpActionResult DeleteJuzz(int id)
        {
            Juzz juzz = db.Juzz.Find(id);
            if (juzz == null)
            {
                return NotFound();
            }

            db.Juzz.Remove(juzz);
            db.SaveChanges();

            return Ok(juzz);
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }

        private bool JuzzExists(int id)
        {
            return db.Juzz.Count(e => e.JuzzId == id) > 0;
        }
    }
}